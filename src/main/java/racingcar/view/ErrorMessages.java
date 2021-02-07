package racingcar.view;

public class ErrorMessages {

    private ErrorMessages() {
        throw new IllegalStateException("ErrorMessages is an utility class");
    }

    public static final String ERROR_NAME_LENGTH = "이름은 최대 다섯 글자만 가능합니다.";
    public static final String ERROR_DUPLICATE_NAMES = "중복되는 이름이 있습니다.";
    public static final String ERROR_NONAME = "이름은 최소 한 글자 이상이어야 합니다.";

    public static final String ERROR_TURN_NOT_INTEGER = "시도 횟수는 숫자여야 합니다.";
    public static final String ERROR_TURN_NOT_POSITIVE = "시도 횟수는 0보다 커야 합니다.";
}
