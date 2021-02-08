package stringcalculator.exception;

public class IllegalCustomDelimiterException extends RuntimeException {
    private static final String MESSAGE = "올바른 구분자가 아닙니다.";

    public IllegalCustomDelimiterException() {
        super(MESSAGE);
    }
}
