package cn.edu.cnu.zhanghao.controller;

import cn.edu.cnu.zhanghao.model.pojo.User;
import cn.edu.cnu.zhanghao.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 控制器基类
 *
 * @author 张浩
 */
public class DemoFacade {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpSession session;

    HttpServletRequest getRequest() {
        return request;
    }

    HttpServletResponse getResponse() {
        return response;
    }

    HttpSession getSession() {
        return session;
    }

    void addSessionUser(User user) {
        session.setAttribute(Constant.USER, user);
    }

    User getSessionUser() {
        return (User) session.getAttribute(Constant.USER);
    }

    void removeSessionUser() {
        session.setAttribute(Constant.USER, null);
    }
}
