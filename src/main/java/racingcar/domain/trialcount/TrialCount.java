package racingcar.domain.trialcount;

public class TrialCount {
    private static final int TRIAL_COUNT_DECREASE_UNIT = 1;

    private int trialCount;

    public TrialCount(final int value) {
        this.trialCount = value;
    }

    public boolean isHigherThanZero() {
        return trialCount > 0;
    }

    public void decrease() {
        trialCount -= TRIAL_COUNT_DECREASE_UNIT;
    }
}
