package service;

import com.alibaba.fastjson.JSONObject;
import domain.Course;
import domain.CourseStateListBill;
import domain.CourseStateView;
import domain.CourseStatesShow;
import domain.CourseTeacher;
import domain.Teacher;
import org.springframework.web.bind.annotation.RequestParam;


import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

/**
 * course课程管理service层
 *
 */
public interface CourseService {
    //查询所有课程信息
    public List<Course> findCourse();
    //通过课程id查询相应课程信息
    public Course findSignCourseByCourseId(int course_id);
    //通过课程名和课程状态查询课程信息
    public  List<Course> findCourseByNameAndStatus(CourseStateView courseStateView) throws InvocationTargetException, IllegalAccessException;
    //通过课程id查询所有课程和老师信息
    public CourseTeacher findCourseAndTeacherByCourseId(int course_id);
    //保存课程和老师信息
    public int saveCourseAndTeacher(CourseTeacher courseTeacher) throws ParseException, InvocationTargetException, IllegalAccessException;
    //修改课程和老师信息
    public int editCourseAndTeacher(CourseTeacher courseTeacher) throws InvocationTargetException, IllegalAccessException;
    //修改课程状态信息
    public int editCourseStatus(int course_id,int course_status) throws ParseException;
    //删除课程信息
    public int removeCourse(String course_num);
    //删除老师信息
    public int removeTeacher(String teacher_num);
}
