package cn.edu.cnu.zhanghao.service.impl;

import cn.edu.cnu.zhanghao.context.DemoException;
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
    public void updatePlan(Plan plan) {
        if (null != plan.getInspection() && Constant.PlanStatus.Stage.COMPLETED == plan.getInspection()) {
            int stuQuantity = studentRepository.findStudentQuantity(plan.getYear());
            if (stuQuantity < plan.getQuantity()) {
                throw new DemoException(StatusCode.STUDENT_QUANTITY_NOT_ENOUGH);
            }
            plan.setStatus(Constant.PlanStatus.EXAMINING);
        }
        if (null != plan.getExam() && Constant.PlanStatus.Stage.COMPLETED == plan.getExam()) {
            List<Student> studentList = studentRepository.findAllByPlanYear(plan.getYear());
            for (Student student : studentList) {
                if (null == student.getExamScore()) {
                    throw new DemoException(StatusCode.EXAM_SCORE_UNENTERED);
                }
            }
            studentList.sort((o1, o2) -> {
                if (o1.getExamScore() < o2.getExamScore()) {
                    return 1;
                } else if (o1.getExamScore().equals(o2.getExamScore())) {
                    return 0;
                } else {
                    return -1;
                }
            });
            for (int index = 0; index < studentList.size(); index++) {
                studentList.get(index).setExamRank(index + 1);
                studentRepository.update(studentList.get(index));
            }
            plan.setStatus(Constant.PlanStatus.INTERVIEWING);
        }
        if (null != plan.getInterview() && Constant.PlanStatus.Stage.COMPLETED == plan.getInterview()) {
            List<Student> studentList = studentRepository.findStudentListInterview(plan.getYear(), plan.getQuantity() * 2);
            for (Student student : studentList) {
                if (null == student.getInterviewScore()) {
                    throw new DemoException(StatusCode.INTERVIEW_SCORE_UNENTERED);
                } else {
                    student.setComprehensiveScore(student.getExamScore() + student.getInterviewScore());
                }
            }
            studentList.sort((o1, o2) -> {
                if (o1.getComprehensiveScore() < o2.getComprehensiveScore()) {
                    return 1;
                } else if (o1.getComprehensiveScore().equals(o2.getComprehensiveScore())) {
                    return 0;
                } else {
                    return -1;
                }
            });
            for (int index = 0; index < studentList.size(); index++) {
                studentList.get(index).setComprehensiveRank(index + 1);
                studentRepository.update(studentList.get(index));
            }
            plan.setStatus(Constant.PlanStatus.ADMITTING);
        }
        if (null != plan.getAdmission() && Constant.PlanStatus.Stage.COMPLETED == plan.getAdmission()) {
            plan.setStatus(Constant.PlanStatus.COMPLETED);
        }
        planRepository.update(plan);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Plan findPlanByYear(String year) {
        return planRepository.findOneByYear(year);
    }
}
