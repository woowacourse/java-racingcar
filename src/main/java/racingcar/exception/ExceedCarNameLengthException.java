package racingcar.exception;

public class ExceedCarNameLengthException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 자동차 이름은 다섯 글자 이하여야 합니다.";

    public ExceedCarNameLengthException() {
        super(ERROR_MESSAGE);
    }
}
