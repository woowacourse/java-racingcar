package racingCar.domain.exception;

public class NullInputException extends IllegalArgumentException {
    public static final String EXCEPTION_NULL_MESSAGE = "1자 이상 입력해주세요.";

    public NullInputException() {
        super(EXCEPTION_NULL_MESSAGE);
    }
}
