package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * user用户列表展示清单工具Bean实体
 */
@Data
public class UserListBillManyPager {
    private Integer currentPage;//当前页数
    private Integer pageSize;//页总数
    private String username;//用户名
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp user_create_time; //用户创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp user_delete_time; //用户删除时间
    @Override
    public String toString() {
        return "UserListBill{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                ", user_create_time=" + user_create_time +
                ", user_delete_time=" + user_delete_time +
                '}';
    }
}
