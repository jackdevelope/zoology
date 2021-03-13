package domain;

import lombok.Data;

/**
 * course_section章节和course_lesson课时工具Bean实体
 */
@Data
public class SectionLesson {
    private Integer course_section_id;//章节id
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private String course_section_num;//章节编号
    private String course_section_name;//章节名
    private String course_section_description;//章节描述
    private Integer course_section_order_num;//章节排序字段
    private java.sql.Timestamp course_section_create_time;//章节创建时间
    private java.sql.Timestamp course_section_update_time;//章节更新时间
    private Integer course_section_status;//章节状态，0:隐藏；1：待更新；2：已发布
    private Integer course_section_is_de;//章节是否删除 0-未删除，1-已删除
    private String course_section_remark;//备注
    private String course_lesson_num;//课时编号
    private String course_lesson_theme;//课时主题
    private Integer course_lesson_duration;//课时时长(分钟)
    private Integer course_lesson_order_num;//课时排序字段
    private java.sql.Timestamp course_lesson_create_time; //课时创建时间
    private java.sql.Timestamp course_lesson_update_time;//课时更新时间
    private Integer course_lesson_status;//课时状态,0-隐藏，1-未发布，2-已发布
    private Integer course_lesson_is_free;//课时是否免费:1.免费2.不免费
    private Integer course_lesson_is_del;//课时是否删除,0未删除，1删除
    private String course_lesson_remark;//备注

    @Override
    public String toString() {
        return "SectionLesson{" +
                "course_section_id=" + course_section_id +
                ", course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_section_num='" + course_section_num + '\'' +
                ", course_section_name='" + course_section_name + '\'' +
                ", course_section_description='" + course_section_description + '\'' +
                ", course_section_order_num=" + course_section_order_num +
                ", course_section_create_time=" + course_section_create_time +
                ", course_section_update_time=" + course_section_update_time +
                ", course_section_status=" + course_section_status +
                ", course_section_is_de=" + course_section_is_de +
                ", course_section_remark='" + course_section_remark + '\'' +
                ", course_lesson_num='" + course_lesson_num + '\'' +
                ", course_lesson_theme='" + course_lesson_theme + '\'' +
                ", course_lesson_duration=" + course_lesson_duration +
                ", course_lesson_order_num=" + course_lesson_order_num +
                ", course_lesson_create_time=" + course_lesson_create_time +
                ", course_lesson_update_time=" + course_lesson_update_time +
                ", course_lesson_status=" + course_lesson_status +
                ", course_lesson_is_free=" + course_lesson_is_free +
                ", course_lesson_is_del=" + course_lesson_is_del +
                ", course_lesson_remark='" + course_lesson_remark + '\'' +
                '}';
    }
}
