package service.impl;

import com.github.pagehelper.PageInfo;
import domain.Menu;
import domain.Resource;
import domain.Role;
import domain.RoleUserIdList;
import domain.User;
import domain.UserListBill;
import domain.UserListBillManyPager;
import domain.User_Role_relation;
import mapper.UserMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.DateUtils;
import util.Md5;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Service实现层
 */
@Service
public class UserServiceImpl implements UserService {
    //登录结果暂存器
    String tempResult="";
    int tempResult0=0;
    //权限结果返回器
    private static Map<String,Object> result = new HashMap<>();
    //实时时间存储器
    private Date date = DateUtils.getDateFormart();
    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() throws ParseException {
    }

    //系统通过手机号查询用户名和密码
    @Override
    public String findUsernameAndPasswordByphone(String user_phone){
       User userResult=userMapper.selUsernameAndPasswordByphone(user_phone);
        System.out.println("userResult"+userResult);
        try {
            if(userResult != null && Md5.verify(userResult.getUser_password(),"lagou",userResult.getUser_password())){
               tempResult=userResult.getUser_id()+"用户密码正确,可以登录:success";
               return tempResult;
            }else {
               tempResult="该用户密码不正确,不可以登录:refuse";
               return tempResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tempResult="异常,请检查原因:Exception";
            return tempResult;
        }
    }
    //用户通过名字和时间进行分页查询信息
    @Override
    public PageInfo findAllUserByNameAndTimePageInformation(UserListBillManyPager userListBillManyPager) throws InvocationTargetException, IllegalAccessException {
        //System.out.println("2"+userListBillManyPager.toString())
        //PageHelper.startPage(userListBillManyPager.getCurrentPage(),userListBillManyPager.getPageSize());
        //封装用户查询条件
        UserListBill userListBill=new UserListBill();
        BeanUtils.copyProperties(userListBill,userListBillManyPager);
        List<User> allUserByPage=userMapper.selAllUserByNameAndTime(userListBill);
        System.out.println("all:"+allUserByPage.size());
        //new出有参对象拿到返回结果
        PageInfo<User> pageInfo=new PageInfo<>(allUserByPage);
        return pageInfo;
    }
    //通过用户id查询用户当前所拥有的所有角色
    @Override
    public Map<String,Object> getUserPermissions(int user_id) {
        //1.获取当前用户拥有的角色
        List<Role> roleList=userMapper.selAllUseAndRoleRelationByuserId(user_id);
        //2.获取角色id,保存到 list
        List<Integer> roleIdResult=new ArrayList<>();
        for (Role role:roleList){
            roleIdResult.add(role.getRole_id());
        }
        //3.根据角色id查询 父菜单
        List<Menu> parentMenu=userMapper.selParentMenuByRoleId(roleIdResult);
        //4.封装父菜单下的子菜单
        for (Menu menu:parentMenu){
          List<Menu> subMenu=userMapper.selSubMenuByPid(menu.getMenu_son_id());
          menu.setSubMenuList(subMenu);
        }
        //5.获取用户所属角色拥有的资源权限
        List<Resource> resourceList=userMapper.selResourceByRoleId(roleIdResult);
        //6.封装最后信息
        result.put("menuList",parentMenu);//菜单信息
        result.put("resourceList",resourceList);
        return result;
    }
    //根据用户id分配角色
    @Override
    public int saveUseAndRoleRelation(RoleUserIdList roleUserIdList) {
        // 根据用户id清空相应用户角色中间表
        userMapper.deleteUserRoleRelation(roleUserIdList.getUser_id());
        // 为用户分配角色
        for (Integer roleid : roleUserIdList.getRoleIdList())
        {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUser_id(user_role_relation.getUser_id());
            user_role_relation.setRole_id(roleid);
            user_role_relation.setUser_role_created_time(date);
            user_role_relation.setUser_role_updated_time(date);
            user_role_relation.setUser_role_created_by("system");
            user_role_relation.setUser_role_updated_by("system");
            tempResult0=userMapper.adduserAndRole(user_role_relation)+tempResult0;
        }
        return tempResult0;
    }
    //根据用户id和所给状态修改用户状态
    @Override
    public int editUserStatus(int user_id, String user_status) {
        return userMapper.updateUserStatus(user_id,user_status);
    }
}
