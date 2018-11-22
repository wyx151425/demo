package cn.edu.cnu.zhanghao.controller;

import cn.edu.cnu.zhanghao.context.DemoException;
import cn.edu.cnu.zhanghao.model.dto.Response;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import cn.edu.cnu.zhanghao.service.StudentService;
import cn.edu.cnu.zhanghao.util.Constant;
import cn.edu.cnu.zhanghao.util.StatusCode;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 学生CRUD API
 *
 * @author 张浩
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "students/import")
    public Response<Student> actionImportStudentAndScore(@RequestParam("file") MultipartFile file) {
        if (!Constant.DocType.XLSX.equals(file.getContentType())) {
            throw new DemoException(StatusCode.FILE_FORMAT_ERROR);
        }
        try {
            studentService.importStudentAndCourseList(file);
        } catch (InvalidFormatException | IOException e) {
            throw new DemoException(e, StatusCode.FILE_RESOLVE_ERROR);
        }
        return new Response<>();
    }

    @GetMapping(value = "students/{id}")
    public Response<Student> actionFindStudentAndCourseList(@PathVariable(value = "id") Integer id) {
        Student student = studentService.findStudentAndCourseList(id);
        return new Response<>(student);
    }

    @GetMapping(value = "students")
    public Response<List<Student>> actionFindStudentListByYear(@RequestParam(value = "year") String year) {
        List<Student> studentList = studentService.findStudentListByYear(year);
        return new Response<>(studentList);
    }
}
