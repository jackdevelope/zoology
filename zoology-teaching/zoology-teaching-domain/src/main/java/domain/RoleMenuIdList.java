package domain;

import lombok.Data;

import java.util.List;
/**
 * RoleMenuIdList角色菜单列表工具Bean实体
 */
@Data
public class RoleMenuIdList {

    private Integer role_id;

    private List<Integer> MenuIdList;

    @Override
    public String toString() {
        return "RoleMenuList{" +
                "role_id=" + role_id +
                ", MenuIdList=" + MenuIdList +
                '}';
    }
}
