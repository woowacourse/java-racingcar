package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class NameValidator {
    private static final Pattern pattern = Pattern.compile("[a-zA-Z가-힣0-9]{1,5}(,[a-zA-Z가-힣0-9]{1,5})*");

    public static void isValidateNames(String carNames) {
        if (!pattern.matcher(carNames).matches()) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public static void isDuplicatedNames(List<String> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}

