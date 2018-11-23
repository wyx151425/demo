package cn.edu.cnu.zhanghao.service.impl;

import cn.edu.cnu.zhanghao.context.DemoException;
import cn.edu.cnu.zhanghao.model.pojo.User;
import cn.edu.cnu.zhanghao.repository.UserRepository;
import cn.edu.cnu.zhanghao.service.UserService;
import cn.edu.cnu.zhanghao.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务逻辑实现
 *
 * @author 张浩
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public User login(User user) {
        User targetUser = userRepository.findOneByUsername(user.getUsername());
        if (null == targetUser) {
            throw new DemoException(StatusCode.USER_UNREGISTERED);
        } else {
            if (0 == targetUser.getStatus()) {
                throw new DemoException(StatusCode.USER_DISABLED);
            } else {
                if (targetUser.getPassword().equals(user.getPassword())) {
                    return targetUser;
                } else {
                    throw new DemoException(StatusCode.USER_PASSWORD_ERROR);
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);
    }
}
