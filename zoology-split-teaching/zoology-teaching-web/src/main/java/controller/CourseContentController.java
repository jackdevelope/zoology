package controller;

import domain.CourseContentStatesShow;
import domain.CourseSection;
import domain.Course_section;
import domain.SectionLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.CourseContentService;
import util.ResponseResult;
import util.ResponseState;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 课程内容管理Controller
 */
@RestController
public class CourseContentController {
    //view结果返回器
    private static ResponseResult responseResult =new ResponseResult();
    //返回结果标志器
    private static int res=0;
    @Autowired
    private CourseContentService courseContentService;
    //通过课程编号查询课程id信息
    @GetMapping(value = "/findSignCourseIdByCourseName/{course_num}")
    public CourseSection findSignCourseIdByCourseNameInformation(@PathVariable String course_num){
        return courseContentService.findSignCourseIdByCourseName(course_num);
    }
    //通过课程id查询课程内容(章节与课时)信息
    @GetMapping(value = "/findCourseContentByCourseId/{course_id}")
    public List<Course_section> findCourseContentByCourseIdInformation(@PathVariable int course_id){
        return courseContentService.findSectionAndLessonByCourseId(course_id);
    }
    //新增或修改章节和课时信息
    @PostMapping(value = "/saveOrEditCourseContent")
    public ResponseResult saveOrEditCourseContentInformation(@RequestBody SectionLesson sectionLesson) throws InvocationTargetException, IllegalAccessException {
        if (sectionLesson.getCourse_section_id() == null){
            res=courseContentService.saveSectionAndLesson(sectionLesson);
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
            res=courseContentService.editSectionAndLesson(sectionLesson);
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
    }
    //修改章节状态信息
    @PostMapping(value = "/editCourseContentStatus/{course_section_id}/{course_section_num}/{course_section_status}/{course_section_update_time}")
    public ResponseResult editCourseContentStatusInformation(@PathVariable int course_section_id,@PathVariable String course_section_num,@PathVariable int course_section_status,@PathVariable java.sql.Timestamp course_section_update_time){
        CourseContentStatesShow courseContentStatesShow = new CourseContentStatesShow();
        courseContentStatesShow.setCourse_section_id(course_section_id);
        courseContentStatesShow.setCourse_section_num(course_section_num);
        courseContentStatesShow.setCourse_section_status(course_section_status);
        courseContentStatesShow.setCourse_section_update_time(course_section_update_time);
        res = courseContentService.editSectionStatus(courseContentStatesShow);
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
    //删除章节信息
    @DeleteMapping(value = "/removeCourseSection/{course_section_num}")
    public ResponseResult removeCourseSectionInformation(String course_section_num){
        res =courseContentService.removeCourseSection(course_section_num);
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
    //删除课时信息
    @DeleteMapping(value = "/removeCourseLesson/{teacher_num}")
    public ResponseResult removeCourseLessonInformation(String course_lesson_num){
        res = courseContentService.removeCourseLesson(course_lesson_num);
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
