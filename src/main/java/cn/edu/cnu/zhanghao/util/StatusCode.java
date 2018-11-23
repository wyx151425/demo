package cn.edu.cnu.zhanghao.util;

/**
 * 响应状态码
 *
 * @author ZhangHao
 */
public class StatusCode {
    public static final int SUCCESS = 200;
    public static final int SYSTEM_ERROR = 500;
    public static final int USER_UNREGISTERED = 1000;
    public static final int USER_REGISTERED = 1001;
    public static final int USER_DISABLED = 1002;
    public static final int USER_PASSWORD_ERROR = 1003;
    public static final int USER_LOGIN_TIMEOUT = 1004;
    public static final int FILE_FORMAT_ERROR = 2000;
    public static final int FILE_RESOLVE_ERROR = 2001;
    public static final int PLAN_IS_EXIST = 3000;
    public static final int EXAM_SCORE_UNENTERED = 4000;
    public static final int INTERVIEW_SCORE_UNENTERED = 4001;
    public static final int STUDENT_QUANTITY_NOT_ENOUGH = 4002;
}
