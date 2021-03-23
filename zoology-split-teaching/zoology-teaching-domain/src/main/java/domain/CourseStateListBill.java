package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * course课程查询工具Bean实体
 * @author lenovo
 */
@Data
public class CourseStateListBill implements Serializable {
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private String course_name;//课程名
    private String course_img_url;//课程图片url
    private String course_brief;//课程简介
    private Double course_price;//课程原价
    private Double course_discounts;//课程优惠价
    private String course_description;//课程描述
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private java.util.Date course_create_auto_online_time; //课程自动上架时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private java.util.Date course_create_auto_finish_online_time;//课程自动下架时间
    private Integer course_status;//课程状态
    private Integer course_sort_num;//课程于草稿时的排序

    @Override
    public String toString() {
        return "CourseStateListBill{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_img_url='" + course_img_url + '\'' +
                ", course_brief='" + course_brief + '\'' +
                ", course_price=" + course_price +
                ", course_discounts=" + course_discounts +
                ", course_description='" + course_description + '\'' +
                ", course_create_auto_online_time=" + course_create_auto_online_time +
                ", course_create_auto_finish_online_time=" + course_create_auto_finish_online_time +
                ", course_status=" + course_status +
                ", course_sort_num=" + course_sort_num +
                '}';
    }
}
