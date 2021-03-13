package service;

import domain.Role;
import domain.RoleMenuIdList;
import domain.RoleResource;
import domain.RoleResourceIdList;
import domain.Role_menu_relation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 角色services层
 */
public interface RoleService {

   //查询所有角色和根据角色名查询所有角色
   public List<Role> findAllRoleOrByName(Role role);
   //查询角色id关联菜单列表id
   public List<Integer> findMenuByRoleId(int role_id);
   //根据角色id查询资源
   public List<RoleResource> findResourceByRoleId(int role_id);
   //为角色id分配菜单
   public int addRoleMenu(RoleMenuIdList roleMenuIdList) throws InvocationTargetException, IllegalAccessException;
   //为角色id分配资源
   public int addRoleResource(RoleResourceIdList roleResourceIdList) throws InvocationTargetException, IllegalAccessException;
   //删除角色
   public int removeRole(int role_id);
}
