package racingcar.validator.exception;

public class TrialCountNotNumericException extends RuntimeException {
    public TrialCountNotNumericException() {
        super("시도 횟수가 숫자가 아닙니다.");
    }
}
