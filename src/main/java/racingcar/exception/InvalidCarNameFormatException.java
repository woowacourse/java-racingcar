package racingcar.exception;

public class InvalidCarNameFormatException extends CustomException {
    private static final int ERROR_NUMBER = 103;

    public InvalidCarNameFormatException() {
        super(ERROR_NUMBER);
    }
}
