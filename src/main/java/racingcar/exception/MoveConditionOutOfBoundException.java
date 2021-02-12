package racingcar.exception;

public class MoveConditionOutOfBoundException extends RuntimeException {
    private final static String MESSAGE = "전진조건은 0-9사이의 값이어야 합니다.";

    public MoveConditionOutOfBoundException() {
        super(MESSAGE);
    }

}