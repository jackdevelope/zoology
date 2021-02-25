package domain;

import lombok.Data;

import java.util.List;
/**
 *  course_section章节实体
 */
@Data
public class Course_section {
    private Integer course_section_id;//章节id
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private String course_section_num;//章节编号
    private String course_section_name;//章节名
    private String course_section_description;//章节描述
    private Integer course_section_order_num;//章节排序字段
    private java.util.Date course_section_create_time;//章节更新时间
    private java.util.Date course_section_update_time;//章节更新时间
    private java.util.Date course_section_delete_time;//章节更新时间
    private Integer course_section_status;//章节状态，0:隐藏；1：待更新；2：已发布
    private Integer course_section_is_de;//章节是否删除 0-未删除，1-已删除
    private String remark;//备注
    private List<Course_lesson> courseLessons;
    @Override
    public String toString() {
        return "Course_section{" +
                "course_section_id=" + course_section_id +
                ", course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_section_num='" + course_section_num + '\'' +
                ", course_section_name='" + course_section_name + '\'' +
                ", course_section_description='" + course_section_description + '\'' +
                ", course_section_order_num=" + course_section_order_num +
                ", course_section_create_time=" + course_section_create_time +
                ", course_section_update_time=" + course_section_update_time +
                ", course_section_delete_time=" + course_section_delete_time +
                ", course_section_status=" + course_section_status +
                ", course_section_is_de=" + course_section_is_de +
                ", remark='" + remark + '\'' +
                ", courseLessons=" + courseLessons +
                '}';
    }
}
