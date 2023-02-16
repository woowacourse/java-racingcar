package exception;

public class CarNameBlankException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 자동차의 이름은 공백이면 안됩니다.";

    public CarNameBlankException() {
        super(MESSAGE);
    }
}
