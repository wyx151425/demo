package cn.edu.cnu.zhanghao.service.impl;

import cn.edu.cnu.zhanghao.model.pojo.Course;
import cn.edu.cnu.zhanghao.model.pojo.Plan;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import cn.edu.cnu.zhanghao.repository.CourseRepository;
import cn.edu.cnu.zhanghao.repository.PlanRepository;
import cn.edu.cnu.zhanghao.repository.StudentRepository;
import cn.edu.cnu.zhanghao.service.StudentService;
import cn.edu.cnu.zhanghao.util.Constant;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生业务逻辑实现
 *
 * @author ZhangHao
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    private final PlanRepository planRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(PlanRepository planRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.planRepository = planRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void importStudentAndCourseList(MultipartFile file) throws IOException, InvalidFormatException {
        Sheet sheet = formatExcelBOM(file);
        int index = 0;
        for (Row row : sheet) {
            if (0 == index) {
                index++;
            } else {
                Student student = Student.newInstance();
                student.setCode(row.getCell(0).toString());
                student.setName(row.getCell(1).toString());
                Course course1 = Course.newInstance("数据结构", Integer.valueOf(row.getCell(2).toString()));
                Course course2 = Course.newInstance("操作系统", Integer.valueOf(row.getCell(3).toString()));
                Course course3 = Course.newInstance("计算机组成原理", Integer.valueOf(row.getCell(4).toString()));
                Course course4 = Course.newInstance("计算机网络", Integer.valueOf(row.getCell(5).toString()));
                Course course5 = Course.newInstance("数据库系统概论", Integer.valueOf(row.getCell(6).toString()));
                Course course6 = Course.newInstance("C语言程序设计", Integer.valueOf(row.getCell(7).toString()));
                Course course7 = Course.newInstance("C++程序设计", Integer.valueOf(row.getCell(8).toString()));
                Course course8 = Course.newInstance("Java程序设计", Integer.valueOf(row.getCell(9).toString()));
                Course course9 = Course.newInstance("Python程序设计", Integer.valueOf(row.getCell(10).toString()));
                Course course10 = Course.newInstance("Android程序设计", Integer.valueOf(row.getCell(11).toString()));
                Course course11 = Course.newInstance("JavaWeb程序设计", Integer.valueOf(row.getCell(12).toString()));
                Course course12 = Course.newInstance("JavaEE程序设计", Integer.valueOf(row.getCell(13).toString()));
                Course course13 = Course.newInstance("离散数学", Integer.valueOf(row.getCell(14).toString()));
                Course course14 = Course.newInstance("软件工程导论", Integer.valueOf(row.getCell(15).toString()));
                Course course15 = Course.newInstance("数据挖掘导论", Integer.valueOf(row.getCell(16).toString()));
                Course course16 = Course.newInstance("算法设计与分析", Integer.valueOf(row.getCell(17).toString()));
                Course course17 = Course.newInstance("软件项目管理", Integer.valueOf(row.getCell(18).toString()));
                Course course18 = Course.newInstance("信息安全概论", Integer.valueOf(row.getCell(19).toString()));
                student.setCourseList(new ArrayList<>());
                student.getCourseList().add(course1);
                student.getCourseList().add(course2);
                student.getCourseList().add(course3);
                student.getCourseList().add(course4);
                student.getCourseList().add(course5);
                student.getCourseList().add(course6);
                student.getCourseList().add(course7);
                student.getCourseList().add(course8);
                student.getCourseList().add(course9);
                student.getCourseList().add(course10);
                student.getCourseList().add(course11);
                student.getCourseList().add(course12);
                student.getCourseList().add(course13);
                student.getCourseList().add(course14);
                student.getCourseList().add(course15);
                student.getCourseList().add(course16);
                student.getCourseList().add(course17);
                student.getCourseList().add(course18);
                saveStudentAndCourseList(student);
            }
        }
    }

    /**
     * 将Excel的每一个单元格格式化为文本格式
     *
     * @param file       文件
     * @return 工作簿
     * @throws InvalidFormatException 文件格式错误
     * @throws IOException            输入输出异常
     */
    private Sheet formatExcelBOM(MultipartFile file) throws InvalidFormatException, IOException {
        // 获取工作簿
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        // 获取BOM的Sheet
        Sheet sheet = workbook.getSheetAt(0);
        // 创建统一风格，格式化每一个单元格
        CellStyle cellStyle = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));
        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellStyle(cellStyle);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            }
        }
        return sheet;
    }

    @Transactional(rollbackFor = Exception.class)
    void saveStudentAndCourseList(Student student) {
        studentRepository.save(student);
        for (Course course : student.getCourseList()) {
            course.setStudentId(student.getId());
            courseRepository.save(course);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Student findStudentAndCourseList(Integer id) {
        Student student = studentRepository.findOne(id);
        student.getCourseList();
        return student;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Student> findStudentListByYear(String year) {
        Plan plan = planRepository.findOneByYear(year);
        if (Constant.PlanStatus.STARTED == plan.getStatus()) {
            if (Constant.PlanStatus.Stage.STARTED == plan.getInspection()) {
                return studentRepository.findAllByPlanYear(year);
            }
            if (Constant.PlanStatus.Stage.STARTED == plan.getExam()) {
                return studentRepository.findStudentListToInterview(year, plan.getQuantity() * 2);
            }
            if (Constant.PlanStatus.Stage.STARTED == plan.getInterview()) {

            }
        } else if (Constant.PlanStatus.COMPLETED == plan.getStatus()) {

        }
        return studentRepository.findAll();
    }
}
