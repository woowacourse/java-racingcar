package racingcar.exception;

public class HasBlankCarNameException extends IllegalArgumentException {
    private static final int ERROR_NUMBER = 102;

    public static int getErrorNumber() {
        return ERROR_NUMBER;
    }
}
