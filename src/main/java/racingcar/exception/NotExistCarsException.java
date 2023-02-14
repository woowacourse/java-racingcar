package racingcar.exception;

public class NotExistCarsException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 106;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
