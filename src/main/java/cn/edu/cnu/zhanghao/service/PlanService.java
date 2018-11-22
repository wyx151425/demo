package cn.edu.cnu.zhanghao.service;

import cn.edu.cnu.zhanghao.model.pojo.Plan;

import java.util.List;

/**
 * 推免计划业务逻辑规范
 *
 * @author 张浩
 */
public interface PlanService {
    /**
     * 保存计划
     *
     * @param plan 推免计划对象
     */
    void savePlan(Plan plan);

    /**
     * 查询计划
     *
     * @return 计划数据集合
     */
    List<Plan> findPlanList();

    /**
     * 计算平均成绩
     *
     * @param year 计划年份
     */
    void calculateAverageScore(String year);
}
