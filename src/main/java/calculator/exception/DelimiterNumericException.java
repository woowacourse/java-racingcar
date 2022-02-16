package calculator.exception;

public class DelimiterNumericException extends RuntimeException {
    public DelimiterNumericException(String delimiter) {
        super("정수는 커스텀 구분자로 지정할 수 없습니다. delimiter : " + delimiter);
    }
}
