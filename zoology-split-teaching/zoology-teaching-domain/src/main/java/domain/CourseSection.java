package domain;

import lombok.Data;
/*
 **
 */

/**
 * courseSection课程章节实体工具Bean
 */
@Data
public class CourseSection {
    Integer course_id;//课程id
    String  course_num;//课程编号
    String  course_name;//课程名
    private String course_section_num;//章节编号
    private String course_section_name;//章节名
    private String course_section_description;//章节描述
    private Integer course_section_order_num;//章节排序字段
    private String course_lesson_theme;//课时主题
    private Integer course_lesson_duration;//课时时长(分钟)

    @Override
    public String toString() {
        return "CourseSection{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_section_num='" + course_section_num + '\'' +
                ", course_section_name='" + course_section_name + '\'' +
                ", course_section_description='" + course_section_description + '\'' +
                ", course_section_order_num=" + course_section_order_num +
                ", course_lesson_theme='" + course_lesson_theme + '\'' +
                ", course_lesson_duration=" + course_lesson_duration +
                '}';
    }
}
