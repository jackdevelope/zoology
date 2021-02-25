package domain;

import lombok.Data;

import java.util.List;
@Data
public class RoleUserIdList {
    private Integer user_id;

    private List<Integer> roleIdList;

    @Override
    public String toString() {
        return "RoleUserIdList{" +
                "user_id=" + user_id +
                ", roleIdList=" + roleIdList +
                '}';
    }
}
