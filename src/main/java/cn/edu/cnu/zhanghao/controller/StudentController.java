package cn.edu.cnu.zhanghao.controller;

import cn.edu.cnu.zhanghao.context.DemoException;
import cn.edu.cnu.zhanghao.model.dto.PlanStudent;
import cn.edu.cnu.zhanghao.model.dto.PlanStudents;
import cn.edu.cnu.zhanghao.model.dto.Response;
import cn.edu.cnu.zhanghao.model.pojo.Plan;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import cn.edu.cnu.zhanghao.service.PlanService;
import cn.edu.cnu.zhanghao.service.StudentService;
import cn.edu.cnu.zhanghao.util.Constant;
import cn.edu.cnu.zhanghao.util.StatusCode;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 学生CRUD API
 *
 * @author 张浩
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class StudentController {

    private final PlanService planService;
    private final StudentService studentService;

    @Autowired
    public StudentController(PlanService planService, StudentService studentService) {
        this.planService = planService;
        this.studentService = studentService;
    }

    @PostMapping(value = "students/import")
    public Response<Student> actionImportStudentAndScore(
            @RequestParam("year") String year,
            @RequestParam("file") MultipartFile file
    ) {
        if (!Constant.DocType.XLSX.equals(file.getContentType())) {
            throw new DemoException(StatusCode.FILE_FORMAT_ERROR);
        }
        try {
            studentService.importStudentAndCourseList(year, file);
        } catch (InvalidFormatException | IOException e) {
            throw new DemoException(e, StatusCode.FILE_RESOLVE_ERROR);
        }
        return new Response<>();
    }

    @GetMapping(value = "students/{id}")
    public Response<PlanStudent> actionFindStudentAndCourseList(@PathVariable(value = "id") Integer id) {
        Student student = studentService.findStudentAndCourseList(id);
        Plan plan = planService.findPlanByYear(student.getPlanYear());
        return new Response<>(new PlanStudent(plan, student));
    }

    @GetMapping(value = "students")
    public Response<PlanStudents> actionFindStudentListByYear(@RequestParam(value = "year") String year) {
        PlanStudents planStudents = studentService.findStudentListByYear(year);
        return new Response<>(planStudents);
    }
}
