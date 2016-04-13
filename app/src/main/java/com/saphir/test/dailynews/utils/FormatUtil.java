package com.saphir.test.dailynews.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 规范句首字母大写
     */
    //确认字符是否为英文字母
    private static Pattern sWordPattern = Pattern.compile("\\w+");

    public static String capitalizeSentence(final String sentence) {
        String result = sentence;
        Matcher matcher = sWordPattern.matcher(result);
        while (matcher.find()) {
            String word = matcher.group();
            //将首字母大写的词，替换原来匹配出来的英文词
            result = result.replace(matcher.group(), capitalize(word));
        }
        return result;
    }

    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
