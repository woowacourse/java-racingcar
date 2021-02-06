package javaracingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputController {
    public static List<String> getCarNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 이 입력되었습니다."); //TODO enum
        }
        return splitInput(input.replace(" ", ""));
    }

    private static List<String> splitInput(String input) {
        List<String> names;
        names = Arrays.asList(input.split(","));
        return names;
    }

    public static int getTrial(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null이 입력되었습니다.");
        }
        return validatePositiveInt(input.replace(" ", ""));
    }

    private static int validatePositiveInt(String input) {
        if (!Pattern.matches("^[1-9]+[0-9]*$", input)) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
        return Integer.parseInt(input);
    }
}
