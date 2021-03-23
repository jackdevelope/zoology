package service;

import domain.Course;
import domain.CourseContentStatesShow;
import domain.CourseSection;
import domain.CourseTeacher;
import domain.Course_lesson;
import domain.Course_section;
import domain.SectionLesson;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
/*
     courseContent课程内容管理Service层
 */
public interface CourseContentService {
    //通过课程id查询课程内容(章节与课时)信息
    public List<Course_section> findSectionAndLessonByCourseId(int course_id);
    //新增章节和课时信息
    public int saveSectionAndLesson(SectionLesson sectionLesson) throws InvocationTargetException, IllegalAccessException;
    //修改章节和课时信息
    public int editSectionAndLesson(SectionLesson sectionLesson) throws InvocationTargetException, IllegalAccessException;
    //修改章节状态信息
    public int editSectionStatus(CourseContentStatesShow courseContentStatesShow);
    //删除章节和课时信息
    public int removeCourseSection(String course_section_num);
    public int removeCourseLesson(String course_lesson_num);
}
