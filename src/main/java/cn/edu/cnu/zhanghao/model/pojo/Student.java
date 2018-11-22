package cn.edu.cnu.zhanghao.model.pojo;

import cn.edu.cnu.zhanghao.util.Constant;

import java.util.List;

/**
 * @author ZhangHao
 */
public class Student extends DemoEntity {
    /**
     * 学号
     */
    private String code;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 推免年份
     */
    private String planYear;
    /**
     * 基础课程平均成绩
     */
    private Integer averageScore;
    /**
     * 英语成绩
     */
    private Integer englishScore;
    /**
     * 专业课成绩
     */
    private Integer proCourseScore;
    /**
     * 附加成绩
     */
    private Integer additionalScore;
    /**
     * 初试成绩
     */
    private Integer examScore;
    /**
     * 初试排名
     */
    private Integer examRank;
    /**
     * 面试成绩
     */
    private Integer interviewScore;
    /**
     * 综合成绩
     */
    private Integer comprehensiveScore;
    /**
     * 综合排名
     */
    private Integer comprehensiveRank;
    /**
     * 课程列表
     */
    private List<Course> courseList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanYear() {
        return planYear;
    }

    public void setPlanYear(String planYear) {
        this.planYear = planYear;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public Integer getProCourseScore() {
        return proCourseScore;
    }

    public void setProCourseScore(Integer proCourseScore) {
        this.proCourseScore = proCourseScore;
    }

    public Integer getAdditionalScore() {
        return additionalScore;
    }

    public void setAdditionalScore(Integer additionalScore) {
        this.additionalScore = additionalScore;
    }

    public Integer getExamScore() {
        return examScore;
    }

    public void setExamScore(Integer examScore) {
        this.examScore = examScore;
    }

    public Integer getExamRank() {
        return examRank;
    }

    public void setExamRank(Integer examRank) {
        this.examRank = examRank;
    }

    public Integer getInterviewScore() {
        return interviewScore;
    }

    public void setInterviewScore(Integer interviewScore) {
        this.interviewScore = interviewScore;
    }

    public Integer getComprehensiveScore() {
        return comprehensiveScore;
    }

    public void setComprehensiveScore(Integer comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
    }

    public Integer getComprehensiveRank() {
        return comprehensiveRank;
    }

    public void setComprehensiveRank(Integer comprehensiveRank) {
        this.comprehensiveRank = comprehensiveRank;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public static Student newInstance() {
        Student student = new Student();
        student.setStatus(Constant.Status.GENERAL);
        return student;
    }
}
