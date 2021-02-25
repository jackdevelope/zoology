package mapper;

import domain.Menu;

import java.util.List;

/**
 * menu菜单管理mapper层
 */
public interface MenuMapper {
    //查询全部的菜单
    public List<Menu> selAllMenu();
    //查询全部的父菜单
    public List<Menu> selAllParentMenu(int menu_type_id);
    //查询父菜单下的全部子菜单
    public List<Menu> selAllSonMenu(int menu_son_id);

}
