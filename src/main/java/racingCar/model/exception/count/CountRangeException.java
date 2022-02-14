package racingCar.model.exception.count;

public class CountRangeException extends IllegalArgumentException {
    public static final String EXCEPTION_ZERO_MESSAGE = "0회 이상 입력해주세요.";

    public CountRangeException() {
        super(EXCEPTION_ZERO_MESSAGE);
    }

}
