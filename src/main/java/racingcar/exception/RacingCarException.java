package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public RacingCarException(final String message) {
        super(ERROR_PREFIX + message);
    }
}
