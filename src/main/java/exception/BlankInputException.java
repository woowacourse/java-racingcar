package exception;

public class BlankInputException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "공백을 입력할 수 없습니다.";

    public BlankInputException() {
        super(DEFAULT_MESSAGE);
    }
}
