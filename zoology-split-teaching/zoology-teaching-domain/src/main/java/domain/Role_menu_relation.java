package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * role_menu_relation角色菜单中间表实体
 */
@Data
public class Role_menu_relation {
    private Integer role_menu_id;//角色菜单id
    private Integer menu_id;//菜单id
    private Integer role_id;//角色id
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date role_menu_created_time;//角色创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date role_menu_updated_time;//角色修改时间
    private String role_menu_created_by;//角色分配人
    private String role_menu_updated_by;//角色分配修改人
    @Override
    public String toString() {
        return "Role_menu_relation{" +
                "role_menu_id=" + role_menu_id +
                ", menu_id=" + menu_id +
                ", role_id=" + role_id +
                ", role_menu_created_time=" + role_menu_created_time +
                ", role_menu_updated_time=" + role_menu_updated_time +
                ", role_menu_created_by='" + role_menu_created_by + '\'' +
                ", role_menu_updated_by='" + role_menu_updated_by + '\'' +
                '}';
    }
}
