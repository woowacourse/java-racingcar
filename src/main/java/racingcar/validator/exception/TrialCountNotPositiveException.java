package racingcar.validator.exception;

public class TrialCountNotPositiveException extends RuntimeException {
    public TrialCountNotPositiveException() {
        super("시도 횟수가 음수나 0이 될 수 없습니다.");
    }
}
