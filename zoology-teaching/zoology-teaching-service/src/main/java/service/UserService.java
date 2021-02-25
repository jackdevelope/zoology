package service;

import com.github.pagehelper.PageInfo;
import domain.Menu;
import domain.Resource;
import domain.ResponseResult;
import domain.Role;
import domain.RoleUserIdList;
import domain.User;
import domain.UserListBillManyPager;
import domain.User_Role_relation;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 用户Service层
 */
public interface UserService {
    //系统通过手机号查询用户名和密码
    public String findUsernameAndPasswordByphone(String user_phone);
    //用户分页查询所有
    public PageInfo findAllUserByNameAndTimePageInformation(UserListBillManyPager userListBillManyPager) throws InvocationTargetException, IllegalAccessException;
    //获取用户权限
    public Map<String,Object> getUserPermissions(int user_id);
    //根据用户id分配角色
    public int saveUseAndRoleRelation(RoleUserIdList roleUserIdList);
    //根据用户id和所给状态修改用户状态
    public int editUserStatus(int user_id,String user_status);


}
