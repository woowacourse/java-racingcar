package racingcar.util;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorUtils {

    public static final int MAX_NAME_LENGTH = 5;
    public static final String CAR_NAMES_INPUT_DELIMITER = ",";
    private static final String NOT_POSITIVE_INTEGER_EXCEPTION = "양수를 입력해야 합니다.";
    private static final String BLANK_NOT_ALLOWED_EXCEPTION = "공백을 입력하면 안 됩니다.";
    private static final String OVER_FIVE_CHARACTERS_EXCEPTION = "5글자 이하의 이름을 입력해야 합니다.";
    private static final String DUPLICATE_CAR_EXCEPTION = "중복된 이름을 입력하면 안 됩니다.";

    public static int validateAndParsePositiveInt(String string) {
        int number = Integer.parseInt(string);
        validatePositiveInt(number);
        return number;
    }

    private static void validatePositiveInt(int number) {
        if (number <= 0) {
            throw new RuntimeException(NOT_POSITIVE_INTEGER_EXCEPTION);
        }
    }

    public static String[] splitAndValidateCarNames(String carNamesString) {
        String[] carNames = carNamesString.split(CAR_NAMES_INPUT_DELIMITER);

        for (String name : carNames) {
            validateNotBlank(name);
            validateNotOverFiveCharacters(name);
        }

        return carNames;
    }

    private static void validateNotBlank(String string) {
        if (string.isBlank()) {
            throw new RuntimeException(BLANK_NOT_ALLOWED_EXCEPTION);
        }
    }

    private static void validateNotOverFiveCharacters(String string) {
        if (string.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(OVER_FIVE_CHARACTERS_EXCEPTION);
        }
    }

    public static void validateNoDuplicateCar(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);
        if (cars.size() != carSet.size()) {
            throw new RuntimeException(DUPLICATE_CAR_EXCEPTION);
        }
    }
}
