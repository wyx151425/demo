package cn.edu.cnu.zhanghao.repository;

import cn.edu.cnu.zhanghao.model.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张浩
 */
@Mapper
@Repository
public interface PlanRepository {
    /**
     * 保存计划
     *
     * @param plan 计划对象
     */
    void save(Plan plan);

    /**
     * 根据年份获取计划
     *
     * @param year 计划年份
     * @return 计划对象
     */
    Plan findOneByYear(String year);

    /**
     * 查询所有的计划
     *
     * @return 计划数据集合
     */
    List<Plan> findAll();

    /**
     * 更新推免计划
     *
     * @param plan 计划对象
     */
    void update(Plan plan);
}
