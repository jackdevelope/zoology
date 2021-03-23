package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * menu菜单实体
 * */
@Data
public class Menu {
    private Integer menu_id;//菜单id
    private String menu_name;//菜单名
    private int menu_parent_id; //父菜单id
    private String menu_href; //菜单路径
    private String menu_icon;//菜单图标
    private String menu_description;//菜单描述
    private Integer menu_order_num;//菜单排序号
    private Integer menu_shown;//菜单是否显示
    private Integer menu_level;//菜单层级，从0开始，越大层级越低
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp menu_created_time;//菜单开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp menu_updated_time;//菜单修改时间
    private String menu_created_by;//菜单创建人
    private String menu_updated_by;//菜单修改人

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_parent_id=" + menu_parent_id +
                ", menu_href='" + menu_href + '\'' +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_description='" + menu_description + '\'' +
                ", menu_order_num=" + menu_order_num +
                ", menu_shown=" + menu_shown +
                ", menu_level=" + menu_level +
                ", menu_created_time=" + menu_created_time +
                ", menu_updated_time=" + menu_updated_time +
                ", menu_created_by='" + menu_created_by + '\'' +
                ", menu_updated_by='" + menu_updated_by + '\'' +
                '}';
    }
}
