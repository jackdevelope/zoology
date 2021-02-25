package mapper;

import domain.Course;
import domain.CourseContentStatesShow;
import domain.CourseSection;
import domain.Course_lesson;
import domain.Course_section;

import java.util.List;
/**
 * 课程内容管理mapper层
 */
public interface CourseContentMapper {
    //通过课程id查询课程名以来进行行章节对应课程信息的回显或直接通过课程id查询相应课程
    public CourseSection selSignCourseIdByCourseName(String course_num);
    //通过课程id查询课程内容(章节与课时)
    public List<Course_section> selSectionAndLessonByCourseId(int course_id);
    //新增章节和课时
    public int addCourseSection(Course_section course_section);
    public int addCourseLesson(Course_lesson course_lesson);
    //修改章节和课时
    public int updateCourseSection(Course_section course_section);
    public int updateCourseLesson(Course_lesson course_lesson);
    //修改章节状态
    public int updateSectionStatus(CourseContentStatesShow courseContentStatesShow);
    //删除章节和课时
    public int deleteCourseSection(String course_section_num);
    public int deleteCourseLesson(String course_lesson_num);

}
