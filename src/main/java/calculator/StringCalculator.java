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

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final static String REGEX_CHECK_NOT_NUMBER = "[^0-9]";
    private final static String DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private final static String HYPHEN = "-";
    private final static int INDEX_OF_DELIMITER = 0;
    private final static Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        List<String> inputs = split(input);
        return addAll(inputs);
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static List<String> split(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            input = matcher.group(2);
            validateNaturalNumberDelimiterMinus(input);
            return Arrays.asList(input.split(customDelimiter));
        }
        return Arrays.asList(input.split(DELIMITER));
    }

    private static void validateNumber(String input) {
        if (input.matches(REGEX_CHECK_NOT_NUMBER)) {
            throw new RuntimeException();
        }
    }

    private static void validateNaturalNumberDelimiterMinus(String input) {
        if (input.contains(HYPHEN + HYPHEN) ||
            Character.toString(input.charAt(INDEX_OF_DELIMITER)).equals(HYPHEN)) {
            throw new RuntimeException();
        }
    }

    private static void validateNaturalNumber(String input) {
        if (input.contains(HYPHEN)) {
            throw new RuntimeException();
        }
    }

    private static int addAll(List<String> inputs) {
        int result = 0;
        for (String inputA : inputs) {
            validateNumber(inputA);
            validateNaturalNumber(inputA);
            result += Integer.parseInt(inputA);
        }
        return result;
    }
}
