package racingcar.exception;

public class DuplicatedCarNameException extends IllegalArgumentException {

    private static final String MESSAGE = "중복된 자동차 이름이 존재합니다.";

    public DuplicatedCarNameException() {
        super(MESSAGE);
    }
}
