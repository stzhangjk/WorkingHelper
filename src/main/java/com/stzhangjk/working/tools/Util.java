package com.stzhangjk.working.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Grady on 2016.3.11.
 */
public class Util {

    /**
     * 半角转换为全角
     *
     * @param strDBC 半角字符串
     * @return 全角字符串
     */
    public static String toSBC(String strDBC) {
        char[] chars = strDBC.toCharArray();
        for (char c : chars) {
            if (c >= 33 && c <= 126) {
                c = (char) (c + 65248);
            } else if (c == ' ') {
                c = '　';
            }
        }
        return new String(chars);
    }

    /**
     * 全角转换为半角
     *
     * @param strSBC 全角字符串
     * @return 半角字符串
     */
    public static String toDBC(String strSBC) {
        char[] chars = strSBC.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65281 && chars[i] <= 65374) {
                chars[i] = (char) (chars[i] - 65281 + 33);
            } else if (chars[i] == '　') {
                chars[i] = ' ';
            }
        }
        return new String(chars);
    }


    /**
     * 匹配寻找字符串中的指定内容
     * @param content 内容来源
     * @param pattern 正则表达式
     * @return 匹配结果
     */
    public static List<String> matchString(String content,Pattern pattern){
        List<String> result = new ArrayList<String>();
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            result.add(matcher.group());
        }
        return result;
    }
}
