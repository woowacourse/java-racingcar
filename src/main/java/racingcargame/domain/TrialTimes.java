package racingcargame.domain;

public class TrialTimes {

    private static final int MINIMUM_TRIAL_TIMES = 1;

    private int trialTimes;

    public TrialTimes(int trialTimes) {
        validate(trialTimes);
        this.trialTimes = trialTimes;
    }

    private void validate(int trialTimes) {
        if (trialTimes < MINIMUM_TRIAL_TIMES) {
            throw new IllegalArgumentException();
        }
    }

    public int getTrialTimes() {
        return trialTimes;
    }
}
