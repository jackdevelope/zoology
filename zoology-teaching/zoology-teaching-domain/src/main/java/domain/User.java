package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * user用户实体
 */
@Data
public class User {
    private Integer user_id;//用户id
    private String user_num;//用户编号
    private String user_neck;//用户昵称
    private String user_name;//用户名字
    private String user_portrait_url;//用户头像url
    private String user_phone;//用户手机号
    private String user_password;//用户密码
    private String user_reg_ip;//用户注册ip
    private Integer user_account_non_expired;//用户是否有效用户:0.有效1.无效
    private Integer user_credentials_non_expired;//用户账号是否未过期:0.未过期1.过期
    private Integer user_account_non_locked;//用户是否锁定:0.未锁定1.锁定
    private String user_status;//用户状态：ENABLE能登录，DISABLE不能登录
    private Integer user_is_del;//用户是否删除:0未删除,1删除
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp user_create_time; //用户创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp user_update_time;//用户修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp user_delete_time; //用户删除时间
    private String user_created_by;//用户创建人
    private String user_updated_by;//用户修改人
    private String user_deleted_by;//用户删除人
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_num='" + user_num + '\'' +
                ", user_neck='" + user_neck + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_portrait_url='" + user_portrait_url + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_reg_ip='" + user_reg_ip + '\'' +
                ", user_account_non_expired=" + user_account_non_expired +
                ", user_credentials_non_expired=" + user_credentials_non_expired +
                ", user_account_non_locked=" + user_account_non_locked +
                ", user_status='" + user_status + '\'' +
                ", user_is_del=" + user_is_del +
                ", user_create_time=" + user_create_time +
                ", user_update_time=" + user_update_time +
                ", user_delete_time=" + user_delete_time +
                '}';
    }
}
