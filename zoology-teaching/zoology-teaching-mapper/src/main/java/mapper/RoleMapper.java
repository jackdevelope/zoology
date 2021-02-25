package mapper;

import domain.Menu;
import domain.Resource;
import domain.Role;
import domain.RoleResource;
import domain.Role_menu_relation;
import domain.Role_resource_relation;

import java.util.List;

/**
 * 角色mapper层
 */
public interface RoleMapper {
   //查询所有角色
   public List<Role> selAllRoleOrByName(Role role);
   //根据角色id查询菜单
   public List<Integer> selMenuByRoleId(int role_id);
   //根据角色id查询资源
   public List<RoleResource> selRoleByRoleId(int role_id);
   public List<Resource> selAllResource(int resource_id);
   //根据角色id清空相应角色菜单中间表
   public int deleteRoleMenuByRoleId(int role_id);
   //为角色增加菜单
   public int addRoleMenu(Role_menu_relation role_menu_relation);
  //根据角色id清空相应角色资源中间表
   public int deleteRoleResourceByRoleId(int role_id);
   //为角色增加资源
   public int addRoleResource(Role_resource_relation role_resource_relation);
   //根据角色id删除角色
   public int deleteRoleByRoleId(int role_id);
}
