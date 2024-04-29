package com.pos.encode.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegularUtil {

    private RegularUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isContainChinese(final CharSequence input) {
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean isChinese(final CharSequence input) {
        return isMatch("^[\u4e00-\u9fa5]+$", input);
    }

    public static boolean isMatch(final String regex, final CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

}