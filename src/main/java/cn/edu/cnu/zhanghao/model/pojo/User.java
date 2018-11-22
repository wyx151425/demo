package cn.edu.cnu.zhanghao.model.pojo;

/**
 * @author ZhangHao
 */
public class User extends DemoEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     *
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
