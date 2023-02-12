package racingcar.view.dto;

import racingcar.util.ErrorMessage;

public class TrialTimesRequest {
    private final int trialTimes;

    public TrialTimesRequest(String userInput) {
        validate(userInput);
        this.trialTimes = Integer.parseInt(userInput);
    }

    private void validate(String userInput) {
        validateBlank(userInput);
        validateInteger(userInput);
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_NULL.message());
        }
    }

    private void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_NUMBER.message());
        }
    }

    public int getTrialTimes() {
        return trialTimes;
    }
}
