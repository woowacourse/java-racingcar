package racingcar.exception;

public class InvalidTrialTimesFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";

    public InvalidTrialTimesFormatException() {
        super(ERROR_MESSAGE);
    }
}
