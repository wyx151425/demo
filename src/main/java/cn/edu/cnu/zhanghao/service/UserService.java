package cn.edu.cnu.zhanghao.service;

import cn.edu.cnu.zhanghao.model.pojo.User;

/**
 * 用户业务逻辑规范
 *
 * @author 张浩
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return 登录成功后返回的用户对象
     */
    User login(User user);

    /**
     * 保存用户
     *
     * @param user 用户对象
     */
    void save(User user);
}
