package racingcar.exception;

public class HasBlankCarNameException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 비어있는 자동차 이름이 존재합니다.";

    public HasBlankCarNameException() {
        super(ERROR_MESSAGE);
    }
}
