package exception;

public class EmptyCarNameException extends IllegalArgumentException {
    private static final String EMPTY_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름은 비어있을 수 없습니다.\n";

    public EmptyCarNameException() {
        super(EMPTY_CAR_NAME_EXCEPTION);
    }
}
