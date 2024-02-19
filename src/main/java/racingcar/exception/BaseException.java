package racingcar.exception;

public class BaseException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR]";

    public BaseException(final String message) {
        super(String.format("%s %s", PREFIX, message));
    }

    public BaseException(final String message, final String details) {
        super(String.format("%s %s : %s", PREFIX, message, details));
    }
}
