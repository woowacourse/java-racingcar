package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class NameValidator {
    private static final Pattern pattern = Pattern.compile("[a-zA-Z가-힣0-9]{1,5}(,[a-zA-Z가-힣0-9]{1,5})*");
    private static final String WRONG_INPUT_MESSAGE = "올바르지 않은 입력입니다.";
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";  

    public static void isValidateNames(String carNames) {
        if (isInvalidPattern(carNames)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    public static void isDuplicatedNames(List<String> cars) {
        if (isContainingDuplicatedName(cars)) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    private static boolean isInvalidPattern(String carNames) {
        return !pattern.matcher(carNames).matches();
    }

    private static boolean isContainingDuplicatedName(List<String> cars) {
        return cars.size() != cars.stream().distinct().count();
    }
}
