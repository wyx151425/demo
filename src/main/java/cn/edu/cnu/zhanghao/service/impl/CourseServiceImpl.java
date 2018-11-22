package cn.edu.cnu.zhanghao.service.impl;

import cn.edu.cnu.zhanghao.model.pojo.Course;
import cn.edu.cnu.zhanghao.repository.CourseRepository;
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

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseList(List<Course> courseList) {
        for (Course course : courseList) {
            courseRepository.update(course);
        }
    }
}
