package controller;

import domain.Menu;
import domain.Resource;
import domain.Role;
import domain.RoleMenuIdList;
import domain.RoleResource;
import domain.RoleResourceIdList;
import domain.Role_menu_relation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.RoleService;
import util.ResponseResult;
import util.ResponseState;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 角色Controller层
 */
@RestController
public class RoleController {
    //view结果返回器
    private static ResponseResult responseResult =new ResponseResult();
    //状态结果返回器res
    private static int res=0;
    @Autowired
    private RoleService roleService;
    //查询所有角色和根据角色名查询所有角色信息
    @GetMapping(value = "/findAllRoleOrByName")
    public ResponseResult findAllRoleOrByNameInformation(@RequestBody Role role){
        List<Role> roleList=roleService.findAllRoleOrByName(role);
        if (roleList.size()>0){
           responseResult.setRes(true);
           responseResult.setState(ResponseState.SUCCESS.getCode());
           responseResult.setMessage("select"+ResponseState.SUCCESS.getMessage());
           responseResult.setContent(roleList);
        }else {
           responseResult.setRes(false);
           responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
           responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
           responseResult.setContent(roleList);
        }
        return responseResult;
    }
    //获取当前角色的资源信息
    @GetMapping(value = "findResourceByRoleId/{role_id}")
    public ResponseResult findResourceByRoleIdInformation(@PathVariable int role_id){
      List<RoleResource> roleResource=roleService.findResourceByRoleId(role_id);
        if (roleResource!=null){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage("select"+ResponseState.SUCCESS.getMessage());
            responseResult.setContent(roleResource);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent(roleResource);
        }
        return responseResult;
    }
    //查询角色id关联菜单列表id信息
    @GetMapping(value = "findMenuByRoleId/{role_id}")
    public ResponseResult findMenuByRoleIdInformation(@PathVariable int role_id){
        List<Integer> menuList=roleService.findMenuByRoleId(role_id);
        if (menuList.size()>0){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage("select"+ResponseState.SUCCESS.getMessage());
            responseResult.setContent(menuList);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent(menuList);
        }
        return responseResult;
    }
    //为角色id分配菜单
    @PostMapping(value = "/addRoleMenu")
    public ResponseResult addRoleMenuInformation(@RequestBody RoleMenuIdList roleMenuIdList){
        try {
            res=roleService.addRoleMenu(roleMenuIdList);
            if (res!=0){
                responseResult.setRes(true);
                responseResult.setState(ResponseState.SUCCESS.getCode());
                responseResult.setMessage("add"+ResponseState.SUCCESS.getMessage());
                responseResult.setContent("角色分配菜单成功,共:"+res+"个角色");
            }else{
                responseResult.setRes(false);
                responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
                responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
                responseResult.setContent("因无当前用户的角色重复导致为角色分配菜单失败");
            }
            return responseResult;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        }
    }
    //为角色id分配资源
    @PostMapping(value = "/addRoleResource")
    public ResponseResult addRoleResourceInformation(@RequestBody RoleResourceIdList roleResourceIdList){
        try {
            res=roleService.addRoleResource(roleResourceIdList);
            if (res!=0){
                responseResult.setRes(true);
                responseResult.setState(ResponseState.SUCCESS.getCode());
                responseResult.setMessage("add"+ResponseState.SUCCESS.getMessage());
                responseResult.setContent("角色分配菜单成功,共:"+res+"个角色");
            }else{
                responseResult.setRes(false);
                responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
                responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
                responseResult.setContent("因无当前用户的角色重复导致为角色分配菜单失败");
            }
            return responseResult;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        }
    }
    //删除角色信息
    @DeleteMapping(value = "/deleteRole/{role_id}")
    public ResponseResult deleteRoleInformation(@PathVariable int role_id){
        res=roleService.removeRole(role_id);
        if (res!=0){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent("删除成功!!!!具体信息为:"+res);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent("删除失败!!!!具体信息为:"+res);
        }
       return responseResult;
    }
}
