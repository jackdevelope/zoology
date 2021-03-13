package domain;

import lombok.Data;

import java.util.List;

/**
 * RoleResourceIdList角色资源列表工具Bean实体
 */
@Data
public class RoleResourceIdList {
    private Integer role_id;

    private List<Integer> resourceIdList;

    @Override
    public String toString() {
        return "RoleResourceList{" +
                "role_id=" + role_id +
                ", resourceIdList=" + resourceIdList +
                '}';
    }
}
