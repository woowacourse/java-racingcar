/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final static String REGEX_NOT_NUMBER = "[^0-9]";
    private final static String DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        return add(split(text));
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.equals("");
    }

    private static void notNaturalNumberException(String text) {
        if (text.contains("-") || text.matches(REGEX_NOT_NUMBER)) {
            throw new RuntimeException();
        }
    }

    private static int add(String[] inputs) {
        int result = 0;
        for (String inputA : inputs) {
            notNaturalNumberException(inputA);
            result += Integer.parseInt(inputA);
        }
        return result;
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            String customDelimiter = validateNoHyphen(matcher.group(1));
            text = matcher.group(2);
            return text.split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static String validateNoHyphen(String delimiter) {
        if (delimiter.equals("-")) {
            throw new RuntimeException("구분자로 -를 사용하실 수 없습니다.");
        }
        return delimiter;
    }
}
