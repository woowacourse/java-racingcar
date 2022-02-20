package racingcar.exception;

public class LessThanMinimumCountException extends RuntimeException {

    public LessThanMinimumCountException(int minimumCount) {
        super("시도 횟수는" + minimumCount + "이상이어야 합니다");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
