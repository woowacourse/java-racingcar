package racingcar.exception;

public class InvalidRangeTrialTimesException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 100 이하여야 합니다.";

    public InvalidRangeTrialTimesException() {
        super(ERROR_MESSAGE);
    }
}
