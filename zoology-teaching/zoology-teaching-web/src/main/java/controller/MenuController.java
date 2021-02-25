package controller;

import domain.Menu;
import domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.MenuService;
import util.ResponseState;

import java.util.List;

/**
 * menu菜单管理controller层
 */
@RestController
public class MenuController {
    //view结果返回器
    private static ResponseResult responseResult =new ResponseResult();
    @Autowired
    private MenuService menuService;
    //查询全部的菜单信息
    @GetMapping(value ="/findAllMenu" )
    public ResponseResult findAllMenuInformation(){
        List<Menu> menuList=menuService.findAllMenu();
        if (menuList.size()>0){
            responseResult.setSign(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage("select"+ResponseState.SUCCESS.getMessage());
            responseResult.setContent(menuList);
        }else {
            responseResult.setSign(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent(menuList);
        }
        return responseResult;
    }
    //查询全部的父子菜单信息
    @GetMapping(value ="/findAllParentAndSonMenu/{menu_type_id}" )
    public ResponseResult findAllParentAndSonMenuInformation(@PathVariable int menu_type_id){
        List<Menu> menuList=menuService.findAllParentAndSonMenuInformation(menu_type_id);
        if (menuList.size()>0){
          responseResult.setSign(true);
          responseResult.setState(ResponseState.SUCCESS.getCode());
          responseResult.setMessage("select"+ResponseState.SUCCESS.getMessage());
          responseResult.setContent(menuList);
        }else {
            responseResult.setSign(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage("select"+ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent(menuList);
        }
        return responseResult;
    }
}
