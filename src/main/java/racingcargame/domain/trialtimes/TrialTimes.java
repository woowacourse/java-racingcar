package racingcargame.domain.trialtimes;

public class TrialTimes {

    private static final int MINIMUM_TRIAL_TIMES = 1;
    private static final String TRIAL_TIMES_SHOULD_NOT_BE_UNDER_ZERO = "시도 횟수는 0이하일 수 없습니다.";

    private int trialTimes;

    public TrialTimes(int trialTimes) {
        validate(trialTimes);
        this.trialTimes = trialTimes;
    }

    private void validate(int trialTimes) {
        if (trialTimes < MINIMUM_TRIAL_TIMES) {
            throw new IllegalArgumentException(TRIAL_TIMES_SHOULD_NOT_BE_UNDER_ZERO);
        }
    }

    public int getTrialTimes() {
        return trialTimes;
    }
}
