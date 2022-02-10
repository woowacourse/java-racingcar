package racingcar;

public class InputValidator {
    private static final String NO_INTEGER_ERROR_MESSAGE = "[ERROR] 정수가 아닌 문자열이 입력되었습니다.";
    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름을 확인해주세요.";

    public static void validateInteger(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NO_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void validateName(String name) {
        if (name.length() > 5 || name.isBlank()) {
            throw new RuntimeException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}
