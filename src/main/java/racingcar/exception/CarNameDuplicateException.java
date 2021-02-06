package racingcar.exception;

public class CarNameDuplicateException extends RuntimeException {
    private static String MESSAGE = "[ERROR]자동차 이름은 중복을 허용하지 않습니다.";

    public CarNameDuplicateException() {
        super(MESSAGE);
    }
}
