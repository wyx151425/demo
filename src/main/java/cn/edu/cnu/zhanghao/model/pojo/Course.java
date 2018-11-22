package cn.edu.cnu.zhanghao.model.pojo;

import cn.edu.cnu.zhanghao.util.Constant;

/**
 * 课程类
 *
 * @author ZhangHao
 */
public class Course extends DemoEntity {
    /**
     * 学生ID
     */
    private Integer studentId;
    /**
     * 学生对象
     */
    private Student student;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程得分
     */
    private Integer score;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static Course newInstance() {
        Course course = new Course();
        course.setStatus(Constant.Status.GENERAL);
        return course;
    }

    public static Course newInstance(String name, Integer score) {
        Course course = new Course();
        course.setStatus(Constant.Status.GENERAL);
        course.setName(name);
        course.setScore(score);
        return course;
    }
}
