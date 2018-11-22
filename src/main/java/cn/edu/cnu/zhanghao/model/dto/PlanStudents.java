package cn.edu.cnu.zhanghao.model.dto;

import cn.edu.cnu.zhanghao.model.pojo.Plan;
import cn.edu.cnu.zhanghao.model.pojo.Student;

import java.util.List;

/**
 * @author 张浩
 */
public class PlanStudents {
    private Plan plan;
    private List<Student> studentList;

    public PlanStudents() {
    }

    public PlanStudents(Plan plan, List<Student> studentList) {
        this.plan = plan;
        this.studentList = studentList;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
