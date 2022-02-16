package calculator.exception;

public class DelimiterLengthOverException extends RuntimeException {
    public DelimiterLengthOverException() {
        super("커스텀 구분자는 한 글자여야 합니다.");
    }
}
