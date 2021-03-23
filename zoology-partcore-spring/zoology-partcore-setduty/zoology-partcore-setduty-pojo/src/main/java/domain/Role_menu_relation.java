package domain;

import lombok.Data;

/**
 * role_menu_relation角色菜单中间表实体
 */
@Data
public class Role_menu_relation {

    private Integer role_menu_id;//角色菜单id
    private Integer menu_id;//菜单id
    private Integer role_id;//角色id

    @Override
    public String toString() {
        return "Role_menu_relation{" +
                "role_menu_id=" + role_menu_id +
                ", menu_id=" + menu_id +
                ", role_id=" + role_id +
                '}';
    }
}
