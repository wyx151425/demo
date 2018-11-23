package cn.edu.cnu.zhanghao.controller;

import cn.edu.cnu.zhanghao.model.dto.Response;
import cn.edu.cnu.zhanghao.model.pojo.User;
import cn.edu.cnu.zhanghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张浩
 */
@RestController
@RequestMapping(value = "api")
public class UserController extends DemoFacade {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "users/login")
    public Response<User> actionUserLogin(@RequestBody User user) {
        User targetUser = userService.login(user);
        addSessionUser(targetUser);
        return new Response<>(targetUser);
    }

    @PostMapping(value = "users/logout")
    public Response<User> actionUserLogout() {
        removeSessionUser();
        return new Response<>();
    }
}
