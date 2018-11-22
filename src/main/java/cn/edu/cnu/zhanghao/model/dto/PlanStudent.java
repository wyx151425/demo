package cn.edu.cnu.zhanghao.model.dto;

import cn.edu.cnu.zhanghao.model.pojo.Plan;
import cn.edu.cnu.zhanghao.model.pojo.Student;

public class PlanStudent {
    private Plan plan;
    private Student student;

    public PlanStudent() {
    }

    public PlanStudent(Plan plan, Student student) {
        this.plan = plan;
        this.student = student;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
