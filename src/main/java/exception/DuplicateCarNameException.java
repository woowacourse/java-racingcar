package exception;

public class DuplicateCarNameException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "이름은 중복될 수 없습니다.";

    public DuplicateCarNameException() {
        super(DEFAULT_MESSAGE);
    }
}
