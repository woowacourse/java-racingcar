package javaracingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputController {
    public static List<String> splitInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null이 입력되었습니다."); //TODO enum
        }

        List<String> names;
        names = Arrays.asList(input.split(","));
        return names;
    }

    public static int getTrialInput(String input) {
        input = input.trim();
        if (!Pattern.matches("^[1-9]+[0-9]*$", input)) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
        return Integer.parseInt(input);
    }
}
