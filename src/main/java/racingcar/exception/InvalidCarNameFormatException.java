package racingcar.exception;

public class InvalidCarNameFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 자동차 이름은 문자와 숫자만 가능합니다.";

    public InvalidCarNameFormatException() {
        super(ERROR_MESSAGE);
    }
}
