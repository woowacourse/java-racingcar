package racingcar.constants.output;

public class ErrorOutputMessages {

    private ErrorOutputMessages() {
        throw new AssertionError();
    }

    public static final String ERROR_NOT_POSITIVE_INTEGER = "양수를 입력해야 합니다.";
    public static final String ERROR_BLANK_NOT_ALLOWED = "공백을 입력하면 안 됩니다.";
    public static final String ERROR_OVER_FIVE_CHARACTERS = "5글자 이하의 이름을 입력해야 합니다.";
    public static final String ERROR_DUPLICATE_NAME = "중복된 이름을 입력하면 안 됩니다.";
    public static final String ERROR_NULL = "null 값을 입력하면 안 됩니다.";
    public static final String ERROR_CARS_EMPTY = "Car 리스트가 비어있습니다.";
    public static final String ERROR_NOT_INTEGER = "정수를 입력해야 합니다.";
}
