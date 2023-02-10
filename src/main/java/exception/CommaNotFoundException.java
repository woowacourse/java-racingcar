package exception;

public class CommaNotFoundException extends RuntimeExceptionImpl {

    private static final String ENTER_NAME_WITH_COMMA = "쉼표로 이름을 구분해주세요.";

    public CommaNotFoundException() {
        super(ENTER_NAME_WITH_COMMA);
    }
}
