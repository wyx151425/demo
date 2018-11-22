package cn.edu.cnu.zhanghao.controller;

import cn.edu.cnu.zhanghao.model.dto.Response;
import cn.edu.cnu.zhanghao.model.pojo.Plan;
import cn.edu.cnu.zhanghao.model.pojo.Student;
import cn.edu.cnu.zhanghao.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 推免计划CRUD API
 * @author 张浩
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping(value = "plans")
    public Response<Plan> actionSavePlan(@RequestBody Plan plan) {
        planService.savePlan(plan);
        return new Response<>();
    }

    @PutMapping(value = "plans")
    public Response<Student> actionUpdatePlan(@RequestBody Plan plan) {
        planService.updatePlan(plan);
        return new Response<>();
    }

    @GetMapping(value = "plans")
    public Response<List<Plan>> actionFindPlanList() {
        List<Plan> planList = planService.findPlanList();
        return new Response<>(planList);
    }
}


