package cn.edu.cnu.zhanghao.service;

import cn.edu.cnu.zhanghao.model.dto.PlanStudents;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 学生业务逻辑规范
 *
 * @author 张浩
 */
public interface StudentService {
    /**
     * 导入学生和成绩的方法
     *
     * @param year 计划年份
     * @param file 包含学生信息和成绩的文件
     * @throws IOException            输入输出错误
     * @throws InvalidFormatException 文件格式错误
     */
    void importStudentAndCourseList(String year, MultipartFile file) throws IOException, InvalidFormatException;

    /**
     * 删除学生对象
     *
     * @param id 学生ID
     */
    void deleteStudent(Integer id);

    /**
     * 更新学生对象
     *
     * @param student 学生对象
     */
    void updateStudent(Student student);

    /**
     * 根据ID查询学生对象
     *
     * @param id 学生ID
     * @return 学生对象
     */
    Student findStudentAndCourseList(Integer id);

    /**
     * 查询所有学生对象
     *
     * @param year 计划年份
     * @return 学生对象集合
     */
    PlanStudents findStudentListByYear(String year);

    /**
     * 查询该年所有的学生
     *
     * @param year   计划年份
     * @param status 状态码
     * @return 学生对象集合
     */
    PlanStudents findStudentListByYearAndStatus(String year, int status);
}
