package calculator.exception;

public class NumberNotPositiveException extends RuntimeException {
    public NumberNotPositiveException(int number) {
        super("음수 값은 포함될 수 없습니다. value : " + number);
    }
}
