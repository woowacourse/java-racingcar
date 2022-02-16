package calculator.exception;

public class DelimiterNotFoundException extends RuntimeException {
    public DelimiterNotFoundException() {
        super("커스텀 구분자가 입력되지 않았습니다.");
    }
}
