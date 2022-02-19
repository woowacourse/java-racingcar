package racingcar.validator;

public class CarNameValidator {
    private static final String NULL_OR_EMPTY_NAME_ERROR_MESSAGE = "이름을 입력하지 않았습니다. 재입력해주세요.";
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "이름을 5글자 이하로 입력해주세요.";
    private static final int MAX_NAME_LENGTH = 5;

    public static void validate(final String name) {
        if (isNullOrEmptyName(name)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_NAME_ERROR_MESSAGE);
        }
        if (isIllegalLength(name)) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isNullOrEmptyName(final String name) {
        return name == null || name.isBlank();
    }

    private static boolean isIllegalLength(final String name) {
        return name.length() > MAX_NAME_LENGTH;
    }
}
