package controller;

import com.github.pagehelper.PageInfo;
import domain.Role;
import domain.RoleUserIdList;
import domain.User;
import domain.UserListBillManyPager;
import domain.User_Role_relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import util.ResponseResult;
import util.ResponseState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户Controller层
 */
@RestController
public class UserController {
    //view结果返回器
    private static ResponseResult responseResult =new ResponseResult();
    //返回结果标志器
    private static String res="";
    private static int res0=0;
    @Autowired
    private UserService userService;
    //系统通过手机号查询用户名和密码信息
    @GetMapping(value = "/findUsernameAndPasswordByphone/{user_phone}")
    public ResponseResult findUsernameAndPasswordByphoneInformation(HttpServletRequest request, @PathVariable String user_phone){
       res=userService.findUsernameAndPasswordByphone(user_phone);
       StringBuilder stringResult=new StringBuilder();
       if (res.contains("success")){
         for(int i=0;i<res.length();i++) {
           if (res.charAt(i) >= 48 && res.charAt(i) <= 57) {
             stringResult.append(res.charAt(i));
           }
         }
         responseResult.setRes(true);
         responseResult.setState(ResponseState.SUCCESS.getCode());
         responseResult.setMessage(ResponseState.SUCCESS.getMessage());
         responseResult.setContent(stringResult);
         //保存access_token
         Map<String,Object> map=new HashMap<>();
         String access_token=UUID.randomUUID().toString();
         map.put("access_token",access_token);
         map.put("user_id",stringResult);
         //保存session
           HttpSession session = request.getSession();
           session.setAttribute("user_id",stringResult);
           session.setAttribute("access_token",access_token);
       }else {
         responseResult.setRes(false);
         responseResult.setState("400");
         responseResult.setMessage("用户名密码错误拒绝登录!!!");
         responseResult.setContent(res);
       }
       return responseResult;
    }
    //用户通过名字和时间并分页查询信息
    @GetMapping(value = "/findAllUserByNameAndTimePage")
    public ResponseResult findAllUserByNameAndTimePageInformation(@RequestBody UserListBillManyPager userListBillManyPager){
       // System.out.println("1"+userListBillManyPager.toString());
        try {
            PageInfo userListBillManyPager0 = userService.findAllUserByNameAndTimePageInformation(userListBillManyPager);
            List<User> list = userListBillManyPager0.getList();
            System.out.println(list);
            if (userListBillManyPager0!=null){
                responseResult.setRes(true);
                responseResult.setState(ResponseState.SUCCESS.getCode());
                responseResult.setMessage(ResponseState.SUCCESS.getMessage());
                responseResult.setContent(userListBillManyPager0);
                return responseResult;
            }else {
                responseResult.setRes(false);
                responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
                responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
                responseResult.setContent(userListBillManyPager0);
                return responseResult;
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        }
    }
    //获取用户权限信息
    @GetMapping(value = "/getUserPermissions")
    public ResponseResult getUserPermissionsInformation(HttpServletRequest request) {
        //获取请求中的token
        String token = request.getHeader("Authorization");
        //获取session中的access_token
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        //判断是不是同一个用户
        if (token.equals(access_token)) {
            int user_id = (Integer) session.getAttribute("user_id");
            Map<String,Object> result=userService.getUserPermissions(user_id);
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setState(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(result);
            return responseResult;
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getMessage());
            responseResult.setContent("无访问权限");
            return responseResult;
        }
    }
    //增加用户的角色信息
    @GetMapping(value = "/UseAndRoleRelation")
    public int addUseAndRoleRelationInformation(@RequestBody RoleUserIdList roleUserIdList) {
        return userService.saveUseAndRoleRelation(roleUserIdList);
    }
    //根据用户id和所给状态修改用户状态信息
    @PutMapping(value = "/editUserState/{user_id}/{user_status}")
    public ResponseResult editUserStatusInformation(@PathVariable int user_id,@PathVariable String user_status){
        if("ENABLE".equalsIgnoreCase(user_status)){
            user_status="DISABLE";
        }else{
            user_status="ENABLE";
        }
        res0=userService.editUserStatus(user_id,user_status);
        if (res0!=0){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(res0);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent(res0);
        }
        return responseResult;
    }
}
