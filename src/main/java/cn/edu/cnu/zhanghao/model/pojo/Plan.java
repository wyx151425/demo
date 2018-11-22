package cn.edu.cnu.zhanghao.model.pojo;

import cn.edu.cnu.zhanghao.util.Constant;

/**
 * 推免计划
 *
 * @author 张浩
 */
public class Plan extends DemoEntity {
    /**
     * 计划年份
     */
    private String year;
    /**
     * 计划招收人数
     */
    private Integer quantity;
    /**
     * 资格审查进行状态
     */
    private Integer inspection;
    /**
     * 笔试进行状态
     */
    private Integer exam;
    /**
     * 面试进行状态
     */
    private Integer interview;
    /**
     * 录取进行状态
     */
    private Integer admission;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getInspection() {
        return inspection;
    }

    public void setInspection(Integer inspection) {
        this.inspection = inspection;
    }

    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    public Integer getInterview() {
        return interview;
    }

    public void setInterview(Integer interview) {
        this.interview = interview;
    }

    public Integer getAdmission() {
        return admission;
    }

    public void setAdmission(Integer admission) {
        this.admission = admission;
    }

    public static Plan newInstance() {
        Plan plan = new Plan();
        plan.setStatus(Constant.Status.GENERAL);
        plan.setInspection(Constant.PlanStatus.Stage.STARTED);
        plan.setExam(Constant.PlanStatus.Stage.NOT_STARTED);
        plan.setInterview(Constant.PlanStatus.Stage.NOT_STARTED);
        plan.setAdmission(Constant.PlanStatus.Stage.NOT_STARTED);
        return plan;
    }
}
