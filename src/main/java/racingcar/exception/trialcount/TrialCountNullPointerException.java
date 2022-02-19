package racingcar.exception.trialcount;

public class TrialCountNullPointerException extends TrialCountException {
    public TrialCountNullPointerException() {
        super("시도 횟수를 찾을 수 없습니다!");
    }
}
