package racingcar.domain.Car.Exception;

public class NameNullOrEmptyException extends NameException {
    private static final String ERROR_MESSAGE = "이름은 공백이거나 빈 문자열이 될 수 없습니다.";

    public NameNullOrEmptyException() {
        super(ERROR_MESSAGE);
    }
}
