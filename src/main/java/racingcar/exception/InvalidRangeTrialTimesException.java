package racingcar.exception;

public class InvalidRangeTrialTimesException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 104;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
