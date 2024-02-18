package racingcar.utils;

import java.util.List;

public class InputValidator {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String NAME_REGEX_PATTERN = "^[a-zA-Z]*$";

    private InputValidator() {
    }

    public static void validateCarName(List<String> names) {
        validateDuplicateNames(names);
        for (String name : names) {
            validateNameLength(name);
            validateNameCharacters(name);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private static void validateDuplicateNames(List<String> names) {
        int distinctNamesCount = (int) names.stream()
                .distinct()
                .count();

        if (distinctNamesCount != names.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void validateNameCharacters(String name) {
        if (!name.matches(NAME_REGEX_PATTERN)) {
            throw new IllegalArgumentException("자동차의 이름은 영어로만 이루어져야 합니다.");
        }
    }

    public static void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 자연수여야 합니다.");
        }
    }
}
