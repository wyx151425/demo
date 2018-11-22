package cn.edu.cnu.zhanghao.repository;

import cn.edu.cnu.zhanghao.model.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张浩
 */
@Mapper
@Repository
public interface StudentRepository {
    /**
     * 保存学生数据
     *
     * @param student 学生对象
     */
    void save(Student student);

    /**
     * 更新学生数据
     *
     * @param student 学生对象
     */
    void update(Student student);

    /**
     * 根据ID查询学生对象
     *
     * @param id 学生ID
     * @return 学生对象
     */
    Student findOne(Integer id);

    /**
     * 查询所有学生对象
     *
     * @return 学生对象集合
     */
    List<Student> findAll();

    /**
     * 根据学年查询学生
     *
     * @param year 年份
     * @return 总数
     */
    List<Student> findAllByPlanYear(String year);

    /**
     * 查询可以参加面试的学生
     *
     * @param year  年份
     * @param limit 人数
     * @return 学生数据集合
     */
    List<Student> findStudentListToInterview(@Param(value = "year") String year, @Param(value = "limit") int limit);
}
