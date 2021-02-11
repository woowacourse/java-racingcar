package racingcar.domain.Car.Exception;

public class NameLengthException extends NameException {
    private static final String ERROR_MESSAGE = "이름은 1글자 이상 5글자 이하여야 합니다.";

    public NameLengthException() {
        super(ERROR_MESSAGE);
    }
}
