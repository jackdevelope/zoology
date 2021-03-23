package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.*;
import java.util.Date;

/**
 * course课程实体
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
        private Integer course_id;//课程id
        private String course_num;//课程编号
        private String course_name;//课程名
        private String course_img_url;//课程图片url
        private String course_brief;//课程简介
        private java.math.BigInteger course_total_num;//课程课时数
        private Integer course_total_duration;//课程总时长(分钟)
        private String course_preview_first_field;//课程预览第一个字段
        private String course_preview_second_field;//课程预览第二个字段
        private Integer course_is_new;//课程是否是新出课程：0.是.1.不是.
        private Double course_price;//课程原价
        private String course_price_tag; //课程原价标签
        private Double course_discounts;//课程优惠价
        private String course_discounts_tag;//课程优惠价标签
        private String course_is_new_des; //课程广告语
        private java.math.BigInteger course_sale;//课程销售量
        private String course_share_img_title;//课程分享title
        private String course_share_img_url;//课程分享图片url
        private String course_share_img_brief;//课程分享简介
        private String course_description;//课程详情
        private String remark;//备注
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
        private Integer course_sort_num;//课程于草稿时的排序
        private Integer course_status;//课程状态，0-草稿，1-上架
        private Integer course_is_del;//课程否删除,0未删除，1删除

        @Override
        public String toString() {
                return "Course{" +
                        "course_id=" + course_id +
                        ", course_num='" + course_num + '\'' +
                        ", course_name='" + course_name + '\'' +
                        ", course_img_url='" + course_img_url + '\'' +
                        ", course_brief='" + course_brief + '\'' +
                        ", course_total_num=" + course_total_num +
                        ", course_total_duration=" + course_total_duration +
                        ", course_preview_first_field='" + course_preview_first_field + '\'' +
                        ", course_preview_second_field='" + course_preview_second_field + '\'' +
                        ", course_is_new=" + course_is_new +
                        ", course_price=" + course_price +
                        ", course_price_tag='" + course_price_tag + '\'' +
                        ", course_discounts=" + course_discounts +
                        ", course_discounts_tag='" + course_discounts_tag + '\'' +
                        ", course_is_new_des='" + course_is_new_des + '\'' +
                        ", course_sale=" + course_sale +
                        ", course_share_img_title='" + course_share_img_title + '\'' +
                        ", course_share_img_url='" + course_share_img_url + '\'' +
                        ", course_share_img_brief='" + course_share_img_brief + '\'' +
                        ", course_description='" + course_description + '\'' +
                        ", remark='" + remark + '\'' +
                        ", course_create_time=" + course_create_time +
                        ", course_update_time=" + course_update_time +
                        ", course_delete_time=" + course_delete_time +
                        ", course_create_auto_online_time=" + course_create_auto_online_time +
                        ", course_create_auto_finish_online_time=" + course_create_auto_finish_online_time +
                        ", course_sort_num=" + course_sort_num +
                        ", course_status=" + course_status +
                        ", course_is_del=" + course_is_del +
                        '}';
        }
}
