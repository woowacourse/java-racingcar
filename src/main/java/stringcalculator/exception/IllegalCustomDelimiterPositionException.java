package stringcalculator.exception;

public class IllegalCustomDelimiterPositionException extends RuntimeException {
    private static final String MESSAGE = "구분자의 위치가 올바르지 않습니다.";

    public IllegalCustomDelimiterPositionException() {
        super(MESSAGE);
    }
}