package racingcar.exception;

public class ExceedCarNameLengthException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 101;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
