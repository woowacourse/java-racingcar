package racingcar.validator;

public class CarNameValidator {
    private static final int MAX_LENGTH = 5;
    private static final String ALLOWED_CHARACTERS = ".*[^0-9a-zA-Zㄱ-ㅎ가-힣_]+.*";
    private static final String NOT_ALLOWED_FORMAT_MESSAGE = "올바르지 않은 입력 형식입니다.";
    private static final String EXCEED_LENGTH_ERROR_MESSAGE = "이름은 최대 5자입니다.";

    public static void validateCarName(String input) {
        if (input.matches(ALLOWED_CHARACTERS)) {
            throw new RuntimeException(NOT_ALLOWED_FORMAT_MESSAGE);
        }
        if (input.length() > MAX_LENGTH) {
            throw new RuntimeException(EXCEED_LENGTH_ERROR_MESSAGE);
        }
    }
}
