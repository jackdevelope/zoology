package service.impl;

import com.alibaba.fastjson.JSONObject;
import domain.Course_lesson;
import domain.Course_section;
import domain.Menu;
import domain.Resource;
import domain.Role;
import domain.RoleMenuIdList;
import domain.RoleResource;
import domain.RoleResourceIdList;
import domain.Role_menu_relation;
import domain.Role_resource_relation;
import mapper.RoleMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;
import util.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
/**
 * 角色services实现层
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    //实时时间存储器
    java.util.Date date = DateUtils.getDateFormart();

    public RoleServiceImpl() throws ParseException {
    }
    //查询所有角色和根据角色名查询所有角色
    @Override
    public List<Role> findAllRoleOrByName(Role role) {
        return roleMapper.selAllRoleOrByName(role);
    }
    //根据角色id查询菜单
    @Override
    public List<Integer> findMenuByRoleId(int role_id) {
        return roleMapper.selMenuByRoleId(role_id);
    }
    //根据角色id查询资源
    @Override
    public List<RoleResource> findResourceByRoleId(int role_id) {
       return roleMapper.selRoleByRoleId(role_id);
    }
    //为角色id分配菜单
    @Override
    public int addRoleMenu(RoleMenuIdList roleMenuIdList) throws InvocationTargetException, IllegalAccessException {
        //角色id标志暂存器以及角色菜单中间表标志暂存器
        int roleIdSignTemp=0,roleMenuSignTemp=0;
        //根据角色id清空相应用户菜单中间表
        roleIdSignTemp=roleMapper.deleteRoleByRoleId(roleMenuIdList.getRole_id());
        // 为角色分菜单
        for (Integer menuId : roleMenuIdList.getMenuIdList())
        {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            //封装角色菜单中间表信息
            role_menu_relation.setRole_id(roleMenuIdList.getRole_id());
            role_menu_relation.setMenu_id(menuId);
            role_menu_relation.setRole_menu_created_time(date);
            role_menu_relation.setRole_menu_updated_time(date);
            role_menu_relation.setRole_menu_created_by("system");
            role_menu_relation.setRole_menu_updated_by("system");
            roleMenuSignTemp=roleMapper.addRoleMenu(role_menu_relation)+roleMenuSignTemp;
        }
        return roleIdSignTemp+roleMenuSignTemp;
    }
    //为角色id分配资源
    @Override
    public int addRoleResource(RoleResourceIdList roleResourceIdList) throws InvocationTargetException, IllegalAccessException {
        //角色id标志暂存器以及角色菜单中间表标志暂存器
        int roleIdSignTemp=0,roleresourceSignTemp=0;
        //根据角色id清空相应用户菜单中间表
        roleIdSignTemp=roleMapper.deleteRoleResourceByRoleId(roleResourceIdList.getRole_id());
        // 为角色分菜单
        for (Integer resourceId : roleResourceIdList.getResourceIdList())
        {
            Role_resource_relation role_resource_relation = new Role_resource_relation();
            //封装角色菜单中间表信息
            role_resource_relation.setRole_id(roleResourceIdList.getRole_id());
            role_resource_relation.setResource_id(resourceId);
            role_resource_relation.setRole_resource_create_time(date);
            role_resource_relation.setRole_resource_update_time(date);
            role_resource_relation.setRole_resource_create_by("system");
            role_resource_relation.setRole_resource_update_by("system");
            roleresourceSignTemp=roleMapper.addRoleResource(role_resource_relation)+roleresourceSignTemp;
        }
        return roleIdSignTemp+roleresourceSignTemp;
    }
    //删除角色
    @Override
    public int removeRole(int role_id) {
        return roleMapper.deleteRoleByRoleId(role_id);
    }

}
