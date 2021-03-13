package service;

import domain.Menu;

import java.util.List;


/**
 * menu菜单管理Service层
 */
public interface MenuService {
     //查询全部的菜单
     public List<Menu> findAllMenu();
     //查询全部的父子菜单信息
     public List<Menu> findAllParentAndSonMenuInformation(int menu_type_id);
}
