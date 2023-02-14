package racingcar.exception;

public class DuplicateCarNamesException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 100;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
