package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * teacher老师实体
 */
@Data
public class Teacher {
    private Integer teacher_id;//老师号
    private Integer course_id;//课程号
    private String course_num;//课程编号
    private String teacher_num;//老师编号
    private String teacher_name;//老师名
    private String teacher_position;//老师职位
    private String teacher_description;//老师职位描述
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date teacher_create_time; //老师创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date teacher_update_time;//老师修改时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date teacher_delete_time;//老师删除时间
    private Integer teacher_is_del;//课程否删除,0未删除，1删除
    private String remark;//备注

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", teacher_num='" + teacher_num + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_position='" + teacher_position + '\'' +
                ", teacher_description='" + teacher_description + '\'' +
                ", teacher_create_time=" + teacher_create_time +
                ", teacher_update_time=" + teacher_update_time +
                ", teacher_delete_time=" + teacher_delete_time +
                ", teacher_is_del=" + teacher_is_del +
                ", remark='" + remark + '\'' +
                '}';
    }
}
