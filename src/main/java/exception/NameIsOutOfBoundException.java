package exception;

public class NameIsOutOfBoundException extends RuntimeExceptionImpl {

    private static final String ENTER_NAME_CORRECT_LENGTH = "이름은 5글자 이하로 입력해주세요.";

    public NameIsOutOfBoundException() {
        super(ENTER_NAME_CORRECT_LENGTH);
    }
}
