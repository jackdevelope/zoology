package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * course回显工具Bean
 */
@Data
public class CourseTeacher {
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private String course_name;//课程名
    private String course_brief;//课程简介
    private Double course_price;//课程原价
    private String course_price_tag; //课程原价标签
    private Double course_discounts;//课程优惠价
    private String course_discounts_tag;//课程优惠价标签
    private String course_description;//课程描述
    private String course_description_mark_down;//课程markdown
    private String course_is_new_des; //课程广告语
    private String course_share_img_url;//课程分享图片url
    private String course_img_url;//课程图片url
    private String course_list_img;//课程列表图片url
    private String course_last_operator_name;//课程最后编辑者姓名
    private String course_preview_first_field;//课程预览第一个字段
    private String course_preview_second_field;//课程预览第二个字段
    private java.math.BigInteger course_sale;//课程销量
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date course_create_time;//课程开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date course_update_time;//课程更新时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date course_delete_time;//课程结束时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date course_create_auto_online_time; //课程自动上架时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date course_create_auto_finish_online_time;//课程自动下架时间
    private java.math.BigInteger course_total_num;//课程课时数
    private Integer course_total_duration;//课程总时长(分钟)
    private Integer course_sort_num;//课程于草稿时的排序
    private Integer course_status;//课程状态，0-草稿，1-上架
    private Integer course_is_new;//课程是否是新出课程：0.是.1.不是.
    private Integer course_is_del;//课程否删除,0未删除，1删除
    private String remark;//备注
    private Integer teacher_id;//老师id
    private String teacher_num;//老师编号
    private String teacher_name;//老师名
    private String teacher_position;//老师职位
    private String teacher_description;//老师描述

    @Override
    public String toString() {
        return "CourseTeacher{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_brief='" + course_brief + '\'' +
                ", course_price=" + course_price +
                ", course_price_tag='" + course_price_tag + '\'' +
                ", course_discounts=" + course_discounts +
                ", course_discounts_tag='" + course_discounts_tag + '\'' +
                ", course_description='" + course_description + '\'' +
                ", course_description_mark_down='" + course_description_mark_down + '\'' +
                ", course_is_new_des='" + course_is_new_des + '\'' +
                ", course_share_img_url='" + course_share_img_url + '\'' +
                ", course_img_url='" + course_img_url + '\'' +
                ", course_list_img='" + course_list_img + '\'' +
                ", course_last_operator_name='" + course_last_operator_name + '\'' +
                ", course_preview_first_field='" + course_preview_first_field + '\'' +
                ", course_preview_second_field='" + course_preview_second_field + '\'' +
                ", course_sale=" + course_sale +
                ", course_create_time=" + course_create_time +
                ", course_update_time=" + course_update_time +
                ", course_delete_time=" + course_delete_time +
                ", course_create_auto_online_time=" + course_create_auto_online_time +
                ", course_create_auto_finish_online_time=" + course_create_auto_finish_online_time +
                ", course_total_num=" + course_total_num +
                ", course_total_duration=" + course_total_duration +
                ", course_sort_num=" + course_sort_num +
                ", course_status=" + course_status +
                ", course_is_new=" + course_is_new +
                ", course_is_del=" + course_is_del +
                ", remark='" + remark + '\'' +
                ", teacher_id=" + teacher_id +
                ", teacher_num='" + teacher_num + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_position='" + teacher_position + '\'' +
                ", teacher_description='" + teacher_description + '\'' +
                '}';
    }
}
