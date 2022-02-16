package racingcar.util;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorUtils {

    public static final int MAX_NAME_LENGTH = 5;
    public static final String RESTART_GAME_INPUT = "y";
    public static final String END_PROGRAM_INPUT = "n";
    private static final String NOT_POSITIVE_INTEGER_EXCEPTION = "양수를 입력해야 합니다.";
    private static final String BLANK_NOT_ALLOWED_EXCEPTION = "공백을 입력하면 안 됩니다.";
    private static final String OVER_FIVE_CHARACTERS_EXCEPTION = "5글자 이하의 이름을 입력해야 합니다.";
    private static final String DUPLICATE_CAR_EXCEPTION = "중복된 이름을 입력하면 안 됩니다.";
    private static final String INVALID_BOOLEAN_STRING_EXCEPTION = "y 혹은 n을 입력해야 합니다.";

    private ValidatorUtils() {
    }

    public static int validateAndParsePositiveInt(String value) {
        int number = Integer.parseInt(value);
        validatePositiveInt(number);
        return number;
    }

    private static void validatePositiveInt(int number) {
        if (number <= 0) {
            throw new RuntimeException(NOT_POSITIVE_INTEGER_EXCEPTION);
        }
    }

    public static void validateNotBlank(String value) {
        if (value.isBlank()) {
            throw new RuntimeException(BLANK_NOT_ALLOWED_EXCEPTION);
        }
    }

    public static void validateNotOverFiveCharacters(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(OVER_FIVE_CHARACTERS_EXCEPTION);
        }
    }

    public static void validateNoDuplicateCar(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);
        if (cars.size() != carSet.size()) {
            throw new RuntimeException(DUPLICATE_CAR_EXCEPTION);
        }
    }

    public static boolean validateAndParseBoolean(String value) {
        validateBooleanString(value);
        return value.equalsIgnoreCase(RESTART_GAME_INPUT);
    }

    private static void validateBooleanString(String value) {
        if (!value.equalsIgnoreCase(RESTART_GAME_INPUT) && !value.equalsIgnoreCase(END_PROGRAM_INPUT)) {
            throw new RuntimeException(INVALID_BOOLEAN_STRING_EXCEPTION);
        }
    }
}
