package domain;

import lombok.Data;

/**
 * role_resource_relation角色资源中间表实体
 */
@Data
public class Role_resource_relation {
    private Integer role_resource_id;//角色菜单id
    private Integer role_id;//菜单id
    private Integer resource_id;//角色id
    @Override
    public String toString() {
        return "role_resource_relation{" +
                "role_resource_id=" + role_resource_id +
                ", role_id=" + role_id +
                ", resource_id=" + resource_id +
                '}';
    }
}
