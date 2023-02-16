package racingcar.exception;

public class InvalidTrialTimesFormatException extends CustomException {
    private static final int ERROR_NUMBER = 105;

    public InvalidTrialTimesFormatException() {
        super(ERROR_NUMBER);
    }
}
