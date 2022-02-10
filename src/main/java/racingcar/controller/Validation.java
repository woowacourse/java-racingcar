package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class Validation {
    public static void carNameValidation(String names) {
        List<String> namesList = Arrays.asList(names.split(","));
        for (String name : namesList) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (!(name.length() >= 1 && name.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 이름은 1자 이상, 5자 이하여야 합니다");
        }
    }
}
