package stringcalculator.exception;

public class ExtractCustomDelimiterException extends RuntimeException {
    private static final String MESSAGE = "커스텀 구분자 추출 에러";

    public ExtractCustomDelimiterException() {
        super(MESSAGE);
    }
}
