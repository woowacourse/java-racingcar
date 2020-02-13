package racingcargame.domain.trialtimes;

public class TrialTimes {

    private static final int MINIMUM_TRIAL_TIMES = 1;

    private int trialTimes;

    public TrialTimes(int trialTimes) {
        validate(trialTimes);
        this.trialTimes = trialTimes;
    }

    private void validate(int trialTimes) {
        if (trialTimes < MINIMUM_TRIAL_TIMES) {
            throw new IllegalArgumentException("시도 횟수는 0이하일 수 없습니다.");
        }
    }

    public int getTrialTimes() {
        return trialTimes;
    }
}
