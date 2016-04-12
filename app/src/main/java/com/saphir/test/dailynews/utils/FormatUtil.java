package com.saphir.test.dailynews.utils;

/**
 * Created by Saphir
 * on 2016/4/11.
 */
public class FormatUtil {

    /**
     * 格式化字符串的长度
     *
     * @param s      需要格式化的字符串
     * @param length 需要省略的最大长度
     * @return 已格式化的字符串
     */
    public static String lengthFormat(String s, int length) {
        if (s.length() > length) {
            return s.substring(0, length) + "...";
        }
        return s;
    }
}
