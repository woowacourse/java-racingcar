package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class Validation {
    public static void carNameValidation(String names) {
        List<String> namesList = Arrays.asList(names.split(",", -1));
        for (String name : namesList) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 1자 이상, 5자 이하여야 합니다");
        }
    }

    public static void tryNumValidation(String tryValue) {
        for (char num : tryValue.toCharArray()) {
            checkCharIsNum(num);
        }
    }

    private static void checkCharIsNum(char num) {
        if (!Character.isDigit(num)) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자만 입력 가능합니다");
        }
    }
}
