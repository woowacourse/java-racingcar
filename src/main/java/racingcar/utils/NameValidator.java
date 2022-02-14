package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class NameValidator {
    private static final Pattern pattern = Pattern.compile("[a-zA-Z가-힣0-9]{1,5}(,[a-zA-Z가-힣0-9]{1,5})*");
    private static final String WRONG_INPUT_MESSAGE = "이름은 최소 한명이상이어야 하고, 이름의 길이는 1글자 이상 5글자 이하여야 합니다.";
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";

    public static void isValidateNames(String carNames) {
        if (isInvalidPattern(carNames)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    public static void isDuplicatedNames(List<String> carNames) {
        if (isContainingDuplicatedName(carNames)) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    private static boolean isInvalidPattern(String carNames) {
        return !pattern.matcher(carNames).matches();
    }

    private static boolean isContainingDuplicatedName(List<String> cars) {
        return cars.size() != getDistinctCarsCount(cars);
    }

    private static long getDistinctCarsCount(List<String> cars) {
        return cars.stream().distinct().count();
    }
}
