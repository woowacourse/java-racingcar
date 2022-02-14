package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String DELIMITER = ",";
    private static final int CAR_LIMIT = 2;
    private static final int CAR_LENGTH_LIMIT = 5;

    public static void carName(String names) {
        checkBlank(names, "자동차 이름은 %s일 수 없습니다.");
        String[] cars = names.split(DELIMITER);
        if (!isCars(cars)) {
            throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
        }
        if (isDuplicated(cars)) {
            throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
        }
        nameValid(cars);
    }

    public static void attempt(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("반복 횟수는 %s일 수 없습니다.");
        }
        if (!isNumber(attempt)) {
            throw new IllegalArgumentException("시도횟수는 숫자를 입력해주세요.");
        }
        if (isNegative(attempt)) {
            throw new IllegalArgumentException("시도횟수는 1이상의 수를 입력해주세요.");
        }
    }

    private static void nameValid(String[] cars) {
        for (String name : cars) {
            checkBlank(name, "자동차 이름은 %s일 수 없습니다.");
            validLength(name);
        }
    }

    private static void checkBlank(String name, String text) {
        if (name == null) {
            throw new NullPointerException(String.format(text, "null"));
        }
        if (name.trim().equals("")) {
            throw new IllegalArgumentException(String.format(text, "공백"));
        }
    }

    private static boolean isCars(String[] names) {
        return names.length >= CAR_LIMIT;
    }

    private static boolean isDuplicated(String[] names) {
        Set<String> carNames = new HashSet<>(Arrays.asList(names));
        return carNames.size() != names.length;
    }

    private static void validLength(String name) {
        if (!(name.trim().length() <= CAR_LENGTH_LIMIT)) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private static boolean isNumber(String string) {
        return string.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static boolean isNegative(String string) {
        int attempt = Integer.parseInt(string);
        return attempt <= 0;
    }
}
