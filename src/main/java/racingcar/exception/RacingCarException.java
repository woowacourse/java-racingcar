package racingcar.exception;

public class RacingCarException extends RuntimeException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public RacingCarException(String message) {
        super(ERROR_PREFIX + message);
    }
}
