package racingcar.exception;

public class DuplicateCarNameException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "차 이름은 중복될 수 없습니다";

    public DuplicateCarNameException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
