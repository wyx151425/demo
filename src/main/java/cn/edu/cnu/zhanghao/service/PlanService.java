package cn.edu.cnu.zhanghao.service;

import cn.edu.cnu.zhanghao.model.pojo.Plan;

import java.time.Year;
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
     * 计算平均成绩
     *
     * @param plan 计划对象
     */
    void updatePlan(Plan plan);

    /**
     * 根据年份获取计划
     *
     * @param year 年
     * @return 计划对象
     */
    Plan findPlanByYear(String year);

    /**
     * 查询计划
     *
     * @return 计划数据集合
     */
    List<Plan> findPlanList();
}
