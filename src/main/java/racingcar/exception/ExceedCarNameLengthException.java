package racingcar.exception;

public class ExceedCarNameLengthException extends CustomException {
    private static final int ERROR_NUMBER = 101;

    public ExceedCarNameLengthException() {
        super(ERROR_NUMBER);
    }
}
