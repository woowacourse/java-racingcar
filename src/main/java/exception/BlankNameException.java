package exception;

public class BlankNameException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "이름은 공백일 수 없습니다.";

    public BlankNameException() {
        super(DEFAULT_MESSAGE);
    }
}
