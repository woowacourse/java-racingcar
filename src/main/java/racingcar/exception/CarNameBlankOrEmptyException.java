package racingcar.exception;

public class CarNameBlankOrEmptyException extends RuntimeException{
    private static String MESSAGE = "[ERROR]자동차 이름으로는 빈값이 들어오면 안된다.";

    public CarNameBlankOrEmptyException() {
        super(MESSAGE);
    }
}
