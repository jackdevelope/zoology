package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * role角色实体
 */
@Data
public class Role {
    private Integer role_id;//角色id
    private String role_name;//角色名
    private String role_code;//角色code
    private String role_description;//角色描述
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp role_created_time; //角色创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp role_updated_time;//角色修改时间
    private String role_created_by;//角色创建人
    private String role_updated_by;//角色更新人
    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_code='" + role_code + '\'' +
                ", role_description='" + role_description + '\'' +
                ", role_created_time=" + role_created_time +
                ", role_updated_time=" + role_updated_time +
                ", role_created_by='" + role_created_by + '\'' +
                ", role_updated_by='" + role_updated_by + '\'' +
                '}';
    }
}
