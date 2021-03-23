package domain;

import lombok.Data;

/**
 * user_Role_relation用户角色中间表实体
 */
@Data
public class User_Role_relation {

    private Integer user_role_id;
    private Integer user_id;
    private Integer role_id;
    @Override
    public String toString() {
        return "User_Role_relation{" +
                "user_role_id=" + user_role_id +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }
}
