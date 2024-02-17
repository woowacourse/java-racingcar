package racingcar.exception;

public class InvalidCarNameLengthException extends IllegalArgumentException {

    private static final String MESSAGE = "이름은 1자 이상 5자 이내로 입력해 주세요.";

    public InvalidCarNameLengthException() {
        super(MESSAGE);
    }
}
