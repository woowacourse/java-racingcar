package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String DELIMITER = ",";
    private static final int CAR_LIMIT = 2;
    private static final int CAR_LENGTH_LIMIT = 5;

    public static void carName(String names) {
        checkBlank(names);
        String[] cars = names.split(DELIMITER);
        if (!isCars(cars)) {
            throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
        }
        if (isDuplicated(cars)) {
            throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
        }
        nameValid(cars);
    }

    private static void nameValid(String[] cars) {
        for (String name : cars) {
            checkBlank(name);
            validLength(name);
        }
    }

    private static void checkBlank(String name) {
        String text = "자동차 이름은 %s일 수 없습니다.";
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
}
