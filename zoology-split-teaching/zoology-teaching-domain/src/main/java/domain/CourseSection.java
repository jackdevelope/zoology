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
    Integer course_id;
    String  course_num;
    String  course_name;

    @Override
    public String toString() {
        return "CourseSection{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}
