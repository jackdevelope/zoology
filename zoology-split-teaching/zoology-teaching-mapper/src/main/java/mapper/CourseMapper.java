package mapper;


import domain.Course;
import domain.CourseStateListBill;
import domain.CourseStateView;
import domain.CourseStatesShow;
import domain.CourseTeacher;
import domain.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * course课程管理mapper层
 */
public interface CourseMapper {
    //查询所有课程
    public List<Course> selAllCourse();
    //通过课程id查询单个课程
    public HashMap selSignCourseByCourseId(int course_id);
    //通过课程名和课程状态模糊查询课程
    public List<Course> selAllCourseByNameAndStatus(CourseStateView courseStateView);
    //通过课程id查询所有课程和老师信息进行回显
    public CourseTeacher selCourseAndTeacherById(int course_id);
    //新增课程和老师
    public int addCourse(Course course);
    public int addTeacher(Teacher teacher);
    //修改课程和老师
    public int updateCourse(Course course);
    public int updateTeacher(Teacher teacher);
    //修改课程状态
    public int updateCourseStatus(CourseStatesShow courseStatesShow);
    //删除课程和老师
    public int deleteCourse(String course_num);
    public int deleteTeacher(String teacher_num);
}
