package service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import domain.Course;
import domain.CourseStateListBill;
import domain.CourseStateView;
import domain.CourseStatesShow;
import domain.CourseTeacher;
import domain.Teacher;
import mapper.CourseMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;
import util.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * course课程管理service实现层
 *
 */
@Service
public class CourseServiceImpl implements CourseService {

    //课程暂存器和老师暂存器及JSON结果暂存器
    private static Course courseMedia=new Course();
     private static Teacher teacherMedia=new Teacher();
    //课程状态回显器
    private static CourseStatesShow courseStateShow = new CourseStatesShow();
    //实时时间存储器
    Date date = DateUtils.getDateFormart();
    //返回结果标志器
    private static int res0=0;
    private static int res1=0;
    //计数器
    private int count=0;
    @Autowired
    private CourseMapper courseMapper;

    public CourseServiceImpl() throws ParseException {
    }

    //查询所有课程信息
    @Override
    public List<Course> findCourse() {
        return courseMapper.selAllCourse();
    }
    //通过课程id查询相应课程信息
    @Override
    public HashMap findSignCourseByCourseId(int course_id){
        return courseMapper.selSignCourseByCourseId(course_id);
    }
    //通过课程名和课程状态查询课程信息
    @Override
    public JSONArray findCourseByNameAndStatus(CourseStateView courseStateView) throws InvocationTargetException, IllegalAccessException {
        //获取原始数据
        List<Course> courseList=courseMapper.selAllCourseByNameAndStatus(courseStateView);
        //准备回显容器及回显数据载入
        //初始回传容器
        JSONArray coursePartInfor=new JSONArray();
        HashMap<String,Object> courseResult=new HashMap<>();
        if (courseList!=null&&courseList.size()!=0){
            //分离原始数据,以来提取回显数据
            for (int i=0;i<courseList.size();i++){
                CourseStateListBill courseStateListBill=new CourseStateListBill();
                //封装部分课程
                BeanUtils.copyProperties(courseStateListBill,courseList.get(i));
                courseResult.put("courseStateListBill:"+i,courseStateListBill);
            }
            //装载回显数据
            for (String key : courseResult.keySet()) {
                 String temp= JSON.toJSONString(courseResult.get(key));
                 coursePartInfor.add(JSONObject.parse(temp));
            }
        }else {
            coursePartInfor.add(JSONObject.toJSONString(courseList));
        }
        return coursePartInfor;
    }
    //通过课程id查询所有课程和老师信息
    @Override
    public CourseTeacher findCourseAndTeacherByCourseId(int course_id) {
        return courseMapper.selCourseAndTeacherById(course_id);
    }
    //保存课程和老师信息
    @Override
    public int saveCourseAndTeacher(CourseTeacher courseTeacher) throws ParseException, InvocationTargetException, IllegalAccessException {
        //设置课程编号和老师编号结果器
         String courseNumResult;
        //封装部分课程
        BeanUtils.copyProperties(courseMedia,courseTeacher);
        //制作课程编号
        //1.制作唯一标识
        long nowDate=System.currentTimeMillis();
        String courseNum=Integer.toHexString((int)nowDate);
        //2.制作核心编号
        StringBuilder coreCourseName=new StringBuilder();
        String teacherName=courseTeacher.getTeacher_name();
        for (int i=0;i<teacherName.length();i++){
            int sign=(int)courseTeacher.getTeacher_name().indexOf(i);
            coreCourseName.append(sign);
        }
        coreCourseName.delete(0,coreCourseName.length()/2);
        courseNumResult=courseNum+coreCourseName;

        //封装课程编号及时间
        //开始计数
        count++;
        courseMedia.setCourse_num(courseNumResult);
        courseMedia.setCourse_create_time(date);
        courseMedia.setCourse_update_time(date);
        courseMedia.setCourse_sort_num(count);
        res0=courseMapper.addCourse(courseMedia);
        //封装老师
        BeanUtils.copyProperties(teacherMedia,courseTeacher);
        //制作老师核心编号
        StringBuilder coreTeacherName=new StringBuilder();
        for (int i=0;i<teacherMedia.getTeacher_name().length();i++){
            int sign=(int)teacherMedia.getTeacher_name().indexOf(i);
            coreTeacherName.append(sign);
        }
        coreTeacherName.delete(0,coreTeacherName.length()/2);
        teacherMedia.setCourse_id(courseMedia.getCourse_id());
        teacherMedia.setCourse_num(courseNumResult);
        teacherMedia.setTeacher_num(courseNumResult+coreTeacherName);
        teacherMedia.setTeacher_create_time(date);
        teacherMedia.setTeacher_update_time(date);
        res1=courseMapper.addTeacher(teacherMedia);
        return res0+res1;
    }
    //修改课程和老师信息
    @Override
    public int editCourseAndTeacher(CourseTeacher courseTeacher) throws InvocationTargetException, IllegalAccessException {
        //封装课程
        BeanUtils.copyProperties(courseMedia,courseTeacher);
        courseMedia.setCourse_update_time(date);
        res0=courseMapper.updateCourse(courseMedia);
        //封装讲师
        BeanUtils.copyProperties(teacherMedia,courseTeacher);
        teacherMedia.setCourse_id(courseMedia.getCourse_id());
        teacherMedia.setTeacher_update_time(date);
        res1=courseMapper.updateTeacher(teacherMedia);
        return res0+res1;
    }
    //修改课程状态信息
    @Override
    public int editCourseStatus(int course_id,int course_status) {
        //数据封装
        courseStateShow.setCourse_id(course_id);
        courseStateShow.setCourse_status(course_status);
        courseStateShow.setCourse_update_time(date);
        return courseMapper.updateCourseStatus(courseStateShow);
    }
    //删除课程信息
    @Override
    public int removeCourse(String course_num) {
        return courseMapper.deleteCourse(course_num);
    }
    //删除老师信息
    @Override
    public int removeTeacher(String teacher_num) {
        return courseMapper.deleteTeacher(teacher_num);
    }

}
