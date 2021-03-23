package controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import domain.Course;
import domain.CourseStateListBill;
import domain.CourseStateView;
import domain.CourseTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.CourseService;
import util.ResponseResult;
import util.ResponseState;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * course课程管理Controller层
 */
@RestController
public class CourseController {
    //view结果返回器
    private static ResponseResult responseResult =new ResponseResult();
    //返回结果标志器
    private static int res=0;
    @Autowired
    private CourseService courseService;
    //查询所有课程信息
    @GetMapping(value = "/findCourse")
    public List<Course> findCourseInformation(){
        return courseService.findCourse();
    }
    //通过课程id查询相应课程信息
    @GetMapping(value = "/findSignCourseByCourseId/{course_id}")
    public ResponseResult findSignCourseByCourseIdInformation(@PathVariable int course_id){
        HashMap courseInfor = courseService.findSignCourseByCourseId(course_id);
        if (courseInfor!=null){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(courseInfor);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setMessage(ResponseState.UNKNOWN_ERROR.getMessage());
            responseResult.setContent(courseInfor);
        }
        return responseResult;
    }
    //通过课程名和课程状态查询课程信息
    @PostMapping(value = "/findCourseByNameAndStatus")
    public ResponseResult findCourseByNameAndStatusInformation(@RequestBody CourseStateView courseStateView) throws InvocationTargetException, IllegalAccessException {
       JSONArray courseStateListBill = courseService.findCourseByNameAndStatus(courseStateView);
        if (courseStateListBill.getJSONObject(0).getString("courseStateListBill")==null&& courseStateListBill.getJSONObject(0).getString("courseStateListBill")==""){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(courseStateListBill);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setMessage(ResponseState.UNKNOWN_ERROR.getMessage());
            responseResult.setContent(courseStateListBill);
        }
        return responseResult;
    }
    //通过课程id查询所有课程和老师信息
    @GetMapping(value = "/findCourseAndTeacherByCourseId/{course_id}")
    public ResponseResult findCourseAndTeacherByCourseIdInformation(@PathVariable int course_id){
       
        CourseTeacher courseTeacher = courseService.findCourseAndTeacherByCourseId(course_id);
        if (courseTeacher!=null){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(courseTeacher);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setMessage(ResponseState.UNKNOWN_ERROR.getMessage());
            responseResult.setContent(courseTeacher);
        }
        return responseResult;
    }
    //保存和修改课程和老师信息
    @PostMapping(value = "/saveOrEditCourseAndTeacher")
    public ResponseResult saveOrEditCourseAndTeacherInformation(@RequestBody CourseTeacher courseTeacher){
     try {
        if (courseTeacher.getCourse_id() == null){
            res=courseService.saveCourseAndTeacher(courseTeacher);
            if (res!=0){
                responseResult.setRes(true);
                responseResult.setState(ResponseState.SUCCESS.getCode());
                responseResult.setMessage(ResponseState.SUCCESS.getMessage());
                responseResult.setContent("保存成功!!!!具体信息为:"+res);
            }else {
                responseResult.setRes(false);
                responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
                responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
                responseResult.setContent("保存失败!!!!具体信息为:"+res);
            }
            return responseResult;
        }else{
            res=courseService.editCourseAndTeacher(courseTeacher);
            if (res!=0){
                responseResult.setRes(true);
                responseResult.setState(ResponseState.SUCCESS.getCode());
                responseResult.setMessage(ResponseState.SUCCESS.getMessage());
                responseResult.setContent("修改成功!!!!具体信息为:"+res);
            }else {
                responseResult.setRes(false);
                responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
                responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
                responseResult.setContent("修改失败!!!!具体信息为:"+res);
            }
            return responseResult;
        }
      } catch (ParseException e) {
          e.printStackTrace();
          responseResult.setRes(false);
          responseResult.setState(ResponseState.PARAM_ERROR.getCode());
          responseResult.setState(ResponseState.PARAM_ERROR.getMessage());
          responseResult.setContent("Date转换异常");
          return responseResult;
      } catch (IllegalAccessException e) {
          e.printStackTrace();
          responseResult.setRes(false);
          responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
          responseResult.setState(ResponseState.UNKNOWN_ERROR.getMessage());
          responseResult.setContent("无访问权限");
          return responseResult;
      } catch (InvocationTargetException e) {
          e.printStackTrace();
          responseResult.setRes(false);
          responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
          responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
          responseResult.setContent("方法内部错误");
          return responseResult;
      }
    }
    //修改课程状态信息
    @PutMapping(value = "/editCourseStatus/{course_id}/{course_status}")
    public ResponseResult editCourseStatusInformation(@PathVariable int course_id,@PathVariable int course_status){
        try {
            res = courseService.editCourseStatus(course_id,course_status);
            if (res!=0){
                responseResult.setRes(true);
                responseResult.setState(ResponseState.SUCCESS.getCode());
                responseResult.setMessage(ResponseState.SUCCESS.getMessage());
                responseResult.setContent("修改成功!!!!具体信息为:"+res);
            }else {
                responseResult.setRes(false);
                responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
                responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
                responseResult.setContent("修改失败!!!!具体信息为:"+res);
            }
            return responseResult;
        } catch (ParseException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.PARAM_ERROR.getCode());
            responseResult.setState(ResponseState.PARAM_ERROR.getMessage());
            responseResult.setContent("Date转换异常");
            return responseResult;
        }
    }
    //删除课程信息
    @DeleteMapping(value = "/removeCourse/{course_num}")
    public ResponseResult removeCourseInformation(@PathVariable String course_num){
       res = courseService.removeCourse(course_num);
       if (res!=0){
         responseResult.setRes(true);
         responseResult.setState(ResponseState.SUCCESS.getCode());
         responseResult.setMessage(ResponseState.SUCCESS.getMessage());
         responseResult.setContent("删除成功!!!!具体信息为:"+res);
       }else {
        responseResult.setRes(false);
        responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
        responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
        responseResult.setContent("删除失败!!!!具体信息为:"+res);
       }
       return responseResult;
    }
    //删除老师信息
    @DeleteMapping(value = "/removeTeacher/{teacher_num}")
    public ResponseResult removeTeacherInformation(@PathVariable String teacher_num){
        res = courseService.removeTeacher(teacher_num);
        if (res!=0){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent("删除成功!!!!具体信息为:"+res);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent("删除失败!!!!具体信息为:"+res);
        }
        return responseResult;
    }


}
