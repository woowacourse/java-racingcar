package racingcar.exception;

public class HasBlankCarNameException extends CustomException {
    private static final int ERROR_NUMBER = 102;

    public HasBlankCarNameException() {
        super(ERROR_NUMBER);
    }
}
