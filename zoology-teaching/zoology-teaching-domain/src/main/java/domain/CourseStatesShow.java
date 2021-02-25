package domain;

import lombok.Data;

/**
 * course状态封装工具Bean
 */
@Data
public class CourseStatesShow {
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private Integer course_status;//课程状态，0-草稿，1-上架
    private java.util.Date course_update_time;//记录课程更新时间

    @Override
    public String toString() {
        return "CourseStatesShow{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_status=" + course_status +
                ", course_update_time=" + course_update_time +
                '}';
    }
}
