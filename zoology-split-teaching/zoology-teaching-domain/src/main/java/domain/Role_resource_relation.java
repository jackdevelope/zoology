package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * role_resource_relation角色资源中间表实体
 */
@Data
public class Role_resource_relation {
    private Integer role_resource_id;//角色菜单id
    private Integer role_id;//菜单id
    private Integer resource_id;//角色id
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date role_resource_create_time;//资源创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date role_resource_update_time;//资源修改时间
    private String role_resource_create_by;//资源创建人
    private String role_resource_update_by;//资源修改人

    @Override
    public String toString() {
        return "Role_resource_relation{" +
                "role_resource_id=" + role_resource_id +
                ", role_id=" + role_id +
                ", resource_id=" + resource_id +
                ", role_resource_create_time=" + role_resource_create_time +
                ", role_resource_update_time=" + role_resource_update_time +
                ", role_resource_create_by='" + role_resource_create_by + '\'' +
                ", role_resource_update_by='" + role_resource_update_by + '\'' +
                '}';
    }
}
