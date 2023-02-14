package racingcar.exception;

public class InvalidCarNameFormatException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 103;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
