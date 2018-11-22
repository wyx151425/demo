package cn.edu.cnu.zhanghao.service.impl;

import cn.edu.cnu.zhanghao.context.DemoException;
import cn.edu.cnu.zhanghao.model.pojo.Course;
import cn.edu.cnu.zhanghao.model.pojo.Plan;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import cn.edu.cnu.zhanghao.repository.PlanRepository;
import cn.edu.cnu.zhanghao.repository.StudentRepository;
import cn.edu.cnu.zhanghao.service.PlanService;
import cn.edu.cnu.zhanghao.util.Constant;
import cn.edu.cnu.zhanghao.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 推免计划业务逻辑实现
 *
 * @author 张浩
 */
@Service("planService")
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository, StudentRepository studentRepository) {
        this.planRepository = planRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePlan(Plan plan) {
        Plan targetPlan = planRepository.findOneByYear(plan.getYear());
        if (null == targetPlan) {
            plan.setStatus(Constant.Status.GENERAL);
            plan.setInspection(Constant.PlanStatus.Stage.STARTED);
            plan.setExam(Constant.PlanStatus.Stage.NOT_STARTED);
            plan.setInterview(Constant.PlanStatus.Stage.NOT_STARTED);
            plan.setAdmission(Constant.PlanStatus.Stage.NOT_STARTED);
            planRepository.save(plan);
        } else {
            throw new DemoException(StatusCode.PLAN_IS_EXIST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Plan> findPlanList() {
        return planRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void calculateAverageScore(String year) {
        List<Student> studentList = studentRepository.findAllByPlanYear(year);
        for (Student student : studentList) {
            List<Course> courseList = student.getCourseList();
            int averageScore;
            int sumScore = 0;
            for (Course course : courseList) {
                sumScore += course.getScore();
            }
            averageScore = sumScore / courseList.size();
            student.setAverageScore(averageScore);
            studentRepository.update(student);
        }
    }
}
