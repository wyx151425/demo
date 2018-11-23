package cn.edu.cnu.zhanghao.util;

/**
 * 常量类
 *
 * @author 张浩
 */
public class Constant {
    public static final String USER = "user";

    public static final class DocType {
        public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        public static final String XLSX_UTF8 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8";
    }

    public static final class Status {
        public static final int GENERAL = 1;
    }

    public static final class PlanStatus {
        public static final int ENDED = 0;
        public static final int STARTED = 1;
        public static final int EXAMINING = 2;
        public static final int INTERVIEWING = 3;
        public static final int ADMITTING = 4;
        public static final int COMPLETED = 5;

        public static final class Stage {
            public static final int NOT_STARTED = 0;
            public static final int STARTED = 1;
            public static final int COMPLETED = 2;
        }
    }
}
