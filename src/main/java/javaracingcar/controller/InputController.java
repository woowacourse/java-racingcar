package javaracingcar.controller;

import java.util.Arrays;
import java.util.List;

public class InputController {
    public static List<String> splitInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null이 입력되었습니다."); //TODO enum
        }

        List<String> names;
        names = Arrays.asList(input.split(","));
        return names;
    }
}
