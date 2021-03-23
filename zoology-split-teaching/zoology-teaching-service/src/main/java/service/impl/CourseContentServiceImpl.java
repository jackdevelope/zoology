package service.impl;

import domain.CourseContentStatesShow;
import domain.CourseSection;
import domain.Course_lesson;
import domain.Course_section;
import domain.SectionLesson;
import mapper.CourseContentMapper;
import mapper.CourseMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseContentService;
import util.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
/**
 * courseContent课程内容管理Service实现层
 */

@Service
public class CourseContentServiceImpl implements CourseContentService {
    //章节暂存器和课时暂存器
    private static Course_section sectionMedia= new Course_section();
    private static Course_lesson lessonMedia = new Course_lesson();
    //课程内容状态器
    private static CourseContentStatesShow courseContentStatesShow = new CourseContentStatesShow();
    //实时时间存储器
    java.util.Date date = DateUtils.getDateFormart();
    //章节和课时状态器
    private static int res0=0;
    private static int res1=0;
    @Autowired
    private CourseContentMapper courseContentMapper;
    @Autowired
    private CourseMapper courseMapper;
    public CourseContentServiceImpl() throws ParseException {
    }
    //通过课程id查询课程内容(章节与课时)信息
    @Override
    public List<Course_section> findSectionAndLessonByCourseId(int course_id) {
        return courseContentMapper.selSectionAndLessonByCourseId(course_id);
    }
    //新增章节和课时
    @Override
    public int saveSectionAndLesson(SectionLesson sectionLesson) throws InvocationTargetException, IllegalAccessException {
        //课程id及编号暂存器
        int course_id=sectionLesson.getCourse_id();
        String course_num=sectionLesson.getCourse_num();
        //封装章节部分信息
        BeanUtils.copyProperties(sectionMedia,sectionLesson);
        //制作章节编号
        //1.制作章节核心编号
        StringBuilder coreSectionName=new StringBuilder();
        String courseSectionName=sectionLesson.getCourse_section_name();
        for (int i=0;i<courseSectionName.length();i++){
          int sign=(int)courseSectionName.indexOf(i);
          coreSectionName.append(sign);
        }
        coreSectionName.delete(0,coreSectionName.length()/2);
        //2.加入章节核心编号并拼接
        String course_section_num=sectionLesson.getCourse_id()+sectionLesson.getCourse_num()+coreSectionName;
        //封装章节编号及章节相应时间,并且追加课程id和编号
        sectionMedia.setCourse_section_num(course_section_num);
        sectionMedia.setCourse_section_create_time(date);
        sectionMedia.setCourse_section_update_time(date);
        res0=courseContentMapper.addCourseSection(sectionMedia);
        //封装课时部分信息
        BeanUtils.copyProperties(lessonMedia,sectionLesson);
        //制作课时核心编号
        //1.制作课时核心编号
        StringBuilder coreLessonTheme=new StringBuilder();
        String lessonTheme=sectionLesson.getCourse_lesson_theme();
        for (int i=0;i<lessonTheme.length();i++){
            int sign=(int)lessonTheme.indexOf(i);
            coreLessonTheme.append(sign);
        }
        coreLessonTheme.delete(0,coreLessonTheme.length()/2);
        //2.加入章节核心编号并拼接
        String course_lesson_num=course_section_num+coreLessonTheme;
        //封装课时编号和课时相应时间以及关联章节id及编号,并且追加课程id和编号
        lessonMedia.setCourse_id(course_id);
        lessonMedia.setCourse_num(course_num);
        lessonMedia.setCourse_section_id(sectionMedia.getCourse_section_id());
        lessonMedia.setCourse_section_num(course_section_num);
        lessonMedia.setCourse_lesson_num(course_lesson_num);
        lessonMedia.setCourse_lesson_create_time(date);
        lessonMedia.setCourse_lesson_update_time(date);
        res0=courseContentMapper.addCourseLesson(lessonMedia);
        return res0+res1;
    }
    //修改章节和课时
    @Override
    public int editSectionAndLesson(SectionLesson sectionLesson) throws InvocationTargetException, IllegalAccessException {
        //封装章节
        BeanUtils.copyProperties(sectionMedia,sectionLesson);
        sectionMedia.setCourse_section_update_time(date);
        res0=courseContentMapper.updateCourseSection(sectionMedia);
        //封装课时
        BeanUtils.copyProperties(lessonMedia,sectionLesson);
        lessonMedia.setCourse_lesson_update_time(date);
        res0=courseContentMapper.updateCourseLesson(lessonMedia);
        return res0+res1;
    }
    //修改章节状态
    @Override
    public int editSectionStatus(CourseContentStatesShow courseContentStatesShow) {
       return courseContentMapper.updateSectionStatus(courseContentStatesShow);
    }
    //删除章节
    @Override
    public int removeCourseSection(String course_section_num) {
        return courseContentMapper.deleteCourseSection(course_section_num);
    }
    //删除课时
    @Override
    public int removeCourseLesson(String course_lesson_num) {
        return courseContentMapper.deleteCourseLesson(course_lesson_num);
    }


}
