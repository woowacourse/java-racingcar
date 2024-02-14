package racingcar.utils;

import java.util.Arrays;

public class Validator {
    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static void validateDuplicateNames(String[] names) {
        int distinctedNamesCount = (int) Arrays.stream(names)
                .distinct()
                .count();

        if (distinctedNamesCount != names.length) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateNameCharacters(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("자동차의 이름은 영어로만 이루어져야 합니다.");
        }
    }

    public static void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 자연수여야 합니다.");
        }
    }
}
