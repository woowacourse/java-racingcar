package racingcar.util;

public class InputValidator {
    public static final String NEGATIVE_TRY_COUNT_MESSAGE = "시도 횟수로 음수를 입력할 수 없습니다.";
    private static final String NO_INTEGER_TRY_COUNT_ERROR_MESSAGE = "정수가 아닌 문자열이 입력되었습니다.";
    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름을 확인해주세요.";

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NO_INTEGER_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    public static void validateNegativeTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new RuntimeException(NEGATIVE_TRY_COUNT_MESSAGE);
        }
    }

    public static void validateName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH || name.isBlank()) {
            throw new RuntimeException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}
