package cn.edu.cnu.zhanghao.service.impl;

import cn.edu.cnu.zhanghao.model.pojo.Course;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import cn.edu.cnu.zhanghao.repository.CourseRepository;
import cn.edu.cnu.zhanghao.repository.StudentRepository;
import cn.edu.cnu.zhanghao.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张浩
 */
@Service(value = "courseService")
public class CourseServiceImpl implements CourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseList(List<Course> courseList) {
        int sum = 0;
        for (Course course : courseList) {
            sum += course.getScore();
            courseRepository.update(course);
        }
        Student student = studentRepository.findOne(courseList.get(0).getStudentId());
        student.setAverageScore(sum / courseList.size());
        studentRepository.update(student);
    }
}
