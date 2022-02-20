package racingCar.model.exception.count;

public class CountNotNumberException extends IllegalArgumentException {
    public static final String EXCEPTION_NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";

    public CountNotNumberException() {
        super(EXCEPTION_NOT_NUMBER_MESSAGE);
    }
}
