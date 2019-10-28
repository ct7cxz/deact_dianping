package org.ct.util;

import java.util.UUID;

public class CommontUtil {

    /**
     * 判断指定的字符串是否为空
     *
     * @param str 判断的字符串
     * @return 返回布尔值的类型
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 生成指定位数的随机数
     *
     * @param number
     * @return
     */
    public static Integer getRandomNum(Integer number) {
        return (int) ((Math.random() * 9 + 1) * Math.pow(10, number - 1));
    }

    /**
     * 获得uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
