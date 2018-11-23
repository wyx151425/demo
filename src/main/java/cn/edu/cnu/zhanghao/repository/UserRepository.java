package cn.edu.cnu.zhanghao.repository;

import cn.edu.cnu.zhanghao.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户数据仓库
 *
 * @author 张浩
 */
@Mapper
@Repository
public interface UserRepository {
    /**
     * 保存用户
     *
     * @param user 用户对象
     */
    void save(User user);

    /**
     * 根据用户名查询用户对象
     *
     * @param username 用户名
     * @return 用户对象
     */
    User findOneByUsername(String username);
}
