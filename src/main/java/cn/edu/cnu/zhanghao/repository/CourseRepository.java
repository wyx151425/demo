package cn.edu.cnu.zhanghao.repository;

import cn.edu.cnu.zhanghao.model.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程数据仓库
 *
 * @author 张浩
 */
@Mapper
@Repository
public interface CourseRepository {
    /**
     * 保存课程数据
     *
     * @param course 课程对象
     */
    void save(Course course);

    /**
     * 更新课程数据
     *
     * @param course 课程对象
     */
    void update(Course course);

    /**
     * 根据学生ID查询关联的课程
     *
     * @param id 学生ID
     * @return 课程数据集合
     */
    List<Course> findAllByStudentId(Integer id);
}
