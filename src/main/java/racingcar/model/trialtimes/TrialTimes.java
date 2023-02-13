package racingcar.model.trialtimes;

import racingcar.util.ErrorMessage;

public class TrialTimes {
    private static final int TRIAL_MAX_TIMES = 100;
    private static final int TRIAL_MIN_TIMES = 1;

    private int trialTimes;

    public TrialTimes(int trialTimes) {
        validate(trialTimes);
        this.trialTimes = trialTimes;
    }

    public void consume() {
        trialTimes -= 1;
    }

    public boolean isGreaterThan(int number) {
        return trialTimes > number;
    }

    private void validate(int trialTimes) {
        validateRange(trialTimes);
    }
    
    private void validateRange(int trialTimes) {
        validateOverMaxRange(trialTimes);
        validateUnderMinRange(trialTimes);
    }

    private void validateOverMaxRange(int trialTimes) {
        if (trialTimes > TRIAL_MAX_TIMES) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_OVER_RANGE.message());
        }
    }

    private void validateUnderMinRange(int trialTimes) {
        if (trialTimes < TRIAL_MIN_TIMES) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_UNDER_RANGE.message());
        }
    }
}
