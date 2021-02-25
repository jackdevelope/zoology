package mapper;

import domain.Menu;
import domain.Resource;
import domain.Role;
import domain.User;
import domain.UserListBill;
import domain.UserListBillManyPager;
import domain.User_Role_relation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理mapper层
 */
public interface UserMapper {
     //通过手机号查询用户名和密码
    public User selUsernameAndPasswordByphone(String user_phone);
    //通过用户名查询密码
    public User selPasswordByUsername(String user_name);
    //用户通过名字和时间进行多条件查询
    public List<User> selAllUserByNameAndTime(UserListBill userListBill);
    //根据id查询用户当前角色
    public List<Role> selUserRelationRoleById(int id);
    //根据用户id查询用户当前角色
    public List<Role> selAllUseAndRoleRelationByuserId(int user_id);
    //根据角色id,查询角色拥有的顶级菜单信息
    public List<Menu> selParentMenuByRoleId(List<Integer> roleids);
    //根据menu_son_id查找子菜单
    public List<Menu> selSubMenuByPid(int menu_son_id);
    //获取用户拥有的资源权限
    public List<Resource> selResourceByRoleId(List<Integer> menuSonIds);
    //根据用户id删除相应用户角色中间表
    public int deleteUserRoleRelation(@Param("user_id") int user_id);
    //增加相应用户的角色
    public int adduserAndRole(User_Role_relation user_role_relation);
    //根据用户id和所给状态修改用户状态
    public int updateUserStatus(@Param("user_id") int user_id,@Param("user_status") String user_status);

}

