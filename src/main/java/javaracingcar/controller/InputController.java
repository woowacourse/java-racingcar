package javaracingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputController {
    private static Pattern pattern = Pattern.compile("^[1-9]+[0-9]*$");
    private static String SPLIT_DELIMITER = ",";

    private InputController() {
    }

    public static List<String> getCarNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 이 입력되었습니다."); //TODO enum
        }
        return splitInput(removeSpace(input));
    }

    private static String removeSpace(String input) {
        return input.replace(" ", "");
    }

    private static List<String> splitInput(String input) {
        return Arrays.asList(input.split(SPLIT_DELIMITER));
    }

    public static int getTrial(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 이 입력되었습니다.");
        }
        return validatePositiveInt(removeSpace(input));
    }

    private static int validatePositiveInt(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
        return Integer.parseInt(input);
    }
}
