package racingcar.exception;

public class InvalidRangeTrialTimesException extends CustomException {
    private static final int ERROR_NUMBER = 104;

    public InvalidRangeTrialTimesException() {
        super(ERROR_NUMBER);
    }
}
