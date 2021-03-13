package service.impl;

import domain.Menu;
import mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MenuService;

import java.util.List;

/**
 * menu菜单管理Service实现层
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    //查询全部的菜单
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.selAllMenu();
    }
    //查询全部的父子菜单信息
    @Override
    public List<Menu> findAllParentAndSonMenuInformation(int menu_type_id) {
        return menuMapper.selAllParentMenu(menu_type_id);
    }
}
