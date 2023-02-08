package exception;

public class WrongNameLengthException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "1 ~ 5글자 사이의 이름을 입력해주세요.";

    public WrongNameLengthException() {
        super(DEFAULT_MESSAGE);
    }
}
