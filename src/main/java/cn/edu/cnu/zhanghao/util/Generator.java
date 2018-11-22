package cn.edu.cnu.zhanghao.util;

import java.util.UUID;

/**
 * 特殊字符串生成器
 *
 * @author ZhangHao
 */
public class Generator {

    public static String getObjectId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
