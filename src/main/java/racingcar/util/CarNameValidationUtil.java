package racingcar.util;

public class CarNameValidationUtil {

    private static final String EMPTY_CAR_NAME = "[ERROR] 자동차 이름이 입력되지 않았습니다.";
    private static final String MORE_THAN_ONE_LETTER = "[ERROR] 1글자 미만의 자동차 이름은 허용되지 않습니다.";
    private static final String LESS_THAN_FIVE_LETTER = "[ERROR] 5글자 초과의 자동차 이름은 허용되지 않습니다.";
    private static final String NO_SPACE = "[ERROR] 공백을 포함하는 자동차 이름은 허용되지 않습니다.";

    private CarNameValidationUtil() {
    }

    public static void validateCarName(String carName, int minLength, int maxLength) {
        validateEmpty(carName);
        validateSpace(carName);
        validateLength(carName, minLength, maxLength);
    }

    private static void validateEmpty(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private static void validateSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(NO_SPACE);
        }
    }

    private static void validateLength(String carName, int minLength, int maxLength) {
        if (carName.length() < minLength) {
            throw new IllegalArgumentException(MORE_THAN_ONE_LETTER);
        }

        if (carName.length() > maxLength) {
            throw new IllegalArgumentException(LESS_THAN_FIVE_LETTER);
        }
    }
}
