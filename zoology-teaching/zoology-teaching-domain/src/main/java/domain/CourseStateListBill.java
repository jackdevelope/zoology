package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * course列表展示清单工具Bean
 */

@Data
public class CourseStateListBill {
    private Integer course_id;//课程id
    private String course_num;//课程编号
    private String course_name;//课程名
    private Double course_price;//课程原价
    private Integer course_status;//课程状态，0-草稿，1-上架
    private Integer course_sort_num;//课程于草稿时的排序

    @Override
    public String toString() {
        return "CourseListBill{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_price=" + course_price +
                ", course_status=" + course_status +
                ", course_sort_num='" + course_sort_num + '\'' +
                '}';
    }
}
