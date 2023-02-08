package exception;

public class WrongRoundException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "올바른(1 이상의 숫자) 라운드를 입력해주세요.";

    public WrongRoundException() {
        super(DEFAULT_MESSAGE);
    }
}
