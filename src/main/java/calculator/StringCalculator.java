package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final String CUSTOM_WITH_DIGITAL_REGEX = "(.*)\\d(.*)";
    private static final String BASIC_SPLITTER = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\n";

    public static Integer splitAndSum(String input) {
        try {
            validateBlank(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        return sumNumbers(convertToIntegerArray(splitString(input)));
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 공백입니다.");
        }
    }

    public static String[] splitString(String input) {
        String regExp = BASIC_SPLITTER;
        if (isCustom(input)) {
            int idx = input.indexOf(CUSTOM_SUFFIX);
            regExp = makeCustom(input, idx);
            input = input.substring(idx + 1);
        }

        return input.split(regExp);
    }

    private static String makeCustom(String input, int idx) {
        String custom = input.substring(2, idx);
        if (custom.matches(CUSTOM_WITH_DIGITAL_REGEX)) {
            throw new IllegalArgumentException("커스텀 구분자 내에 숫자가 포함되어 있습니다.");
        }
        return custom;
    }

    private static boolean isCustom(String input) {
        return input.startsWith(CUSTOM_PREFIX) && input.contains(CUSTOM_SUFFIX);
    }

    public static List<Integer> convertToIntegerArray(String[] strArr) {
        List<Integer> numList = new ArrayList<>();
        if (isEmptyList(strArr)) {
            return numList;
        }

        for (String num : strArr) {
            numList.add(convertToInt(num));
        }
        return numList;
    }

    private static boolean isEmptyList(String[] strArr) {
        return Arrays.stream(strArr).count() == 1 && strArr[0].equals("");
    }

    private static Integer convertToInt(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력 값은 숫자여야 합니다.");
        }
        isPositive(value);

        return value;
    }

    private static void isPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("입력 값은 0 이상의 정수여야 합니다.");
        }
    }

    private static Integer sumNumbers(List<Integer> numList) {
        return numList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
