package domain;

import lombok.Data;

/**
 * courseContent状态封装工具Bean
 */
@Data
public class CourseContentStatesShow {
    private Integer course_section_id;//章节id
    private String course_section_num;//章节编号
    private Integer course_section_status;//章节状态:章节状态，0:隐藏；1：待更新；2：已发布
    private java.sql.Timestamp course_section_update_time;//记录课程更新时间

    @Override
    public String toString() {
        return "CourseContentStatesShow{" +
                "course_section_id=" + course_section_id +
                ", course_section_num='" + course_section_num + '\'' +
                ", course_section_status=" + course_section_status +
                ", course_section_update_time=" + course_section_update_time +
                '}';
    }
}
