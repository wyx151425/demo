package cn.edu.cnu.zhanghao.controller;

import cn.edu.cnu.zhanghao.model.dto.Response;
import cn.edu.cnu.zhanghao.model.pojo.Course;
import cn.edu.cnu.zhanghao.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张浩
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PutMapping(value = "courses")
    public Response<Course> actionUpdateCourse(@RequestBody List<Course> courseList) {
        courseService.updateCourseList(courseList);
        return new Response<>();
    }
}
