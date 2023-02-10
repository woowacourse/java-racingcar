package exception;

public class NotPositiveIntegerException extends RuntimeExceptionImpl {

    private static final String ENTER_POSITIVE_INTEGER = "양의 정수를 입력해주세요.";

    public NotPositiveIntegerException() {
        super(ENTER_POSITIVE_INTEGER);
    }
}
