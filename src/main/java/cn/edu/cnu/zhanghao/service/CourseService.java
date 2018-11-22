package cn.edu.cnu.zhanghao.service;

import cn.edu.cnu.zhanghao.model.pojo.Course;

import java.util.List;

/**
 * @author 张浩
 */
public interface CourseService {
    /**
     * 更新课程数据
     *
     * @param courseList 课程数据集合
     */
    void updateCourseList(List<Course> courseList);
}
