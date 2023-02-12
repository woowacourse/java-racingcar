package exception;

public class InputNumberRangeException extends RuntimeException{
    private static final String COUNT_EXCEPTION_MESSAGE = "[ERROR] 0보다 큰 숫자를 입력해야 합니다.";

    public InputNumberRangeException() {
        super(COUNT_EXCEPTION_MESSAGE);
    }
}
