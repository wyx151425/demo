package cn.edu.cnu.zhanghao.context;

/**
 * @author ZhangHao
 */
public class DemoException extends RuntimeException {
    private int statusCode;

    public DemoException(int statusCode) {
        this.statusCode = statusCode;
    }

    public DemoException(Throwable cause, int statusCode) {
        super(cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
