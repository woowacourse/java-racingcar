package exception;

public class WrongRangeMovableNumberException extends IllegalStateException {

    private static final String DEFAULT_MESSAGE =
            "자동차가 전진할 수 있는 범위는 0 ~ 9 사이여야 합니다.";

    public WrongRangeMovableNumberException() {
        super(DEFAULT_MESSAGE);
    }
}
