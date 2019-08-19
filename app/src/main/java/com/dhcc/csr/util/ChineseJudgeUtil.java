package com.dhcc.csr.util;

/**
 * @Author: wlsh
 * @Date: 2019/8/12 10:22
 * @Description: 中文判定工具
 */
public class ChineseJudgeUtil {
    /**
     * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ： 4E00-9FBF：CJK 统一表意符号
     * Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS ：F900-FAFF：CJK 兼容象形文字
     * Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A ：3400-4DBF：CJK 统一表意符号扩展 A
     * Character.UnicodeBlock.GENERAL_PUNCTUATION ：2000-206F：常用标点
     * Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION ：3000-303F：CJK 符号和标点
     * Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS ：FF00-FFEF：半角及全角形式
     */

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  // GENERAL_PUNCTUATION 判断中文的“号
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION     // CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS    // HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
        ) {
            return true;
        }
        return false;
    }


    /**
     * 判断字符串是否包含中文或中文标点符号
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (isChinese(c))
                return true;
        }
        return false;
    }
}
