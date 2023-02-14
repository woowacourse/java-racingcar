package racingcar.exception;

public class InvalidTrialTimesFormatException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 105;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
