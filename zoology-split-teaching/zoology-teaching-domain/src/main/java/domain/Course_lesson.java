package domain;

import lombok.Data;
/**
 *  course_lesson课时实体
 */
@Data
public class Course_lesson {
    private Integer course_lesson_id;//课时id
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private Integer course_section_id;//章节id
    private String course_section_num;//章节编号
    private String course_lesson_num;//课时编号
    private String course_lesson_theme;//课时主题
    private Integer course_lesson_duration;//课时时长(分钟)
    private Integer course_lesson_order_num;//课时排序字段
    private java.util.Date course_lesson_create_time; //课时创建时间
    private java.util.Date course_lesson_update_time;//课时更新时间
    private Integer course_lesson_status;//课时状态:0."已隐藏",1."待更新",2."已更新"
    private Integer course_lesson_is_free;//课时是否免费:1.免费2.不免费

    @Override
    public String toString() {
        return "Course_lesson{" +
                "course_lesson_id=" + course_lesson_id +
                ", course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_section_id=" + course_section_id +
                ", course_section_num='" + course_section_num + '\'' +
                ", course_lesson_num='" + course_lesson_num + '\'' +
                ", course_lesson_theme='" + course_lesson_theme + '\'' +
                ", course_lesson_duration=" + course_lesson_duration +
                ", course_lesson_order_num=" + course_lesson_order_num +
                ", course_lesson_create_time=" + course_lesson_create_time +
                ", course_lesson_update_time=" + course_lesson_update_time +
                ", course_lesson_status=" + course_lesson_status +
                ", course_lesson_is_free=" + course_lesson_is_free +
                '}';
    }
}
