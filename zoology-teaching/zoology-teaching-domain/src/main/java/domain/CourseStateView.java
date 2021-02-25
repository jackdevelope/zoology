package domain;

import lombok.Data;

@Data
public class CourseStateView {
    private String course_name;//课程名
    private Integer course_status;//课程状态，0-草稿，1-上架

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getCourse_status() {
        return course_status;
    }

    public void setCourse_status(Integer course_status) {
        this.course_status = course_status;
    }

    @Override
    public String toString() {
        return "CourseStateView{" +
                "course_name='" + course_name + '\'' +
                ", course_status=" + course_status +
                '}';
    }
}
