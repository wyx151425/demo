package cn.edu.cnu.zhanghao.context;

import cn.edu.cnu.zhanghao.model.dto.Response;
import cn.edu.cnu.zhanghao.util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 应用通用异常处理器
 *
 * @author 王振琦
 */
@RestControllerAdvice
public class DemoExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DemoExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Response<Object> handleException(Exception e) {
        logger.error("-----SummerExceptionHandler-----", e);
        return new Response<>(StatusCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = DemoException.class)
    public Response<Object> handleSummerException(DemoException e) {
        logger.error("-----SummerExceptionHandler-----", e);
        return new Response<>(e.getStatusCode());
    }
}
