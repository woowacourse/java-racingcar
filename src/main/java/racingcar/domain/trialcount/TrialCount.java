package racingcar.domain.trialcount;

public class TrialCount {
    private static final int TRIAL_COUNT_DECREASE_UNIT = 1;
    private int value;

    public TrialCount(final int value) {
        this.value = value;
    }

    public boolean isHigherThanZero() {
        return value > 0;
    }

    public void decrease() {
        value -= TRIAL_COUNT_DECREASE_UNIT;
    }
}
