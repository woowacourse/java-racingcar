package calculator.exception;

public class StringNotNumericException extends RuntimeException {
    public StringNotNumericException(String value) {
        super("전달된 배열의 원소는 반드시 숫자여야 합니다. value : " + value);
    }
}
