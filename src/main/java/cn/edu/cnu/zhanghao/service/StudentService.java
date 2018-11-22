package cn.edu.cnu.zhanghao.service;

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
     * @param file 包含学生信息和成绩的文件
     * @throws IOException            输入输出错误
     * @throws InvalidFormatException 文件格式错误
     */
    void importStudentAndCourseList(MultipartFile file) throws IOException, InvalidFormatException;

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
    List<Student> findStudentListByYear(String year);
}
