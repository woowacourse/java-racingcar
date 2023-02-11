package racingcar.view.dto;

import racingcar.util.ErrorMessage;

public class TrialTimesRequest {
    private static final int TRIAL_MAX_TIMES = 100;
    private static final int TRIAL_MIN_TIMES = 1;

    private final int trialTimes;

    public TrialTimesRequest(String trialTimes) {
        validate(trialTimes);
        this.trialTimes = Integer.parseInt(trialTimes);
    }

    private void validate(String trialTimes) {
        validateNumber(trialTimes);
        validateRange(trialTimes);
    }

    private void validateNumber(String trialTimes) {
        try {
            Integer.parseInt(trialTimes);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_NUMBER.message());
        }
    }
    
    private void validateRange(String trialTimes) {
        int trialTimesNumber = Integer.parseInt(trialTimes);

        validateOverMaxRange(trialTimesNumber);
        validateUnderMinRange(trialTimesNumber);
    }

    private void validateOverMaxRange(int trialTimesNumber) {
        if (trialTimesNumber > TRIAL_MAX_TIMES) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_OVER_RANGE.message());
        }
    }

    private void validateUnderMinRange(int trialTimesNumber) {
        if (trialTimesNumber < TRIAL_MIN_TIMES) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_UNDER_RANGE.message());
        }
    }

    public int getTrialTimes() {
        return trialTimes;
    }
}
