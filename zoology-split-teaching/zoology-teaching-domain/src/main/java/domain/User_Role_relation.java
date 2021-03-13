package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * user_Role_relation用户角色中间表实体
 */
@Data
public class User_Role_relation {

    private Integer user_role_id;//用户角色id
    private Integer user_id;//用户id
    private Integer role_id;//角色id
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date user_role_created_time;//角色赋予时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date user_role_updated_time;//角色更改时间
    private String user_role_created_by;//角色赋予人
    private String user_role_updated_by;//角色更改人
    @Override
    public String toString() {
        return "User_Role_relation{" +
                "user_role_id=" + user_role_id +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                ", user_role_created_time=" + user_role_created_time +
                ", user_role_updated_time=" + user_role_updated_time +
                ", user_role_created_by='" + user_role_created_by + '\'' +
                ", user_role_updated_by='" + user_role_updated_by + '\'' +
                '}';
    }
}
