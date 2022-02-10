package racingcar;

import java.util.Arrays;

public class Validator {

    public static void checkName(String nameString) {
        String[] names = nameString.split(",");

        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상이여야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이는 5글자 이하여야 합니다.");
        }
    }

    private static boolean isBlankOrNull(String nameString) {
        return nameString == null || nameString.isEmpty();
    }

    public static void checkInput(String nameString) {
        if (isBlankOrNull(nameString)) {
            throw new IllegalArgumentException("입력값은 1글자 이상이여야 합니다");
        }

        if (isEmpty(nameString.split(","))) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }

        if (hasDuplication(nameString)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static boolean isEmpty(String[] array) {
        return array.length <= 0;
    }
}
