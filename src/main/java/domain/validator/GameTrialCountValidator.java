package domain.validator;

import validation.ErrorMessage;

import java.util.regex.Pattern;

public class GameTrialCountValidator {

    private static final int MIN_TRIAL_COUNT = 1;
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");

    public static void validateTrialCount(String trialCount) {
        checkDigit(trialCount);
        checkTrialCount(trialCount);
    }

    private static void checkDigit(String trialCount) {
        if (!NUMBER.matcher(trialCount).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_NUMBER.getErrorMessage());
        }
    }

    private static void checkTrialCount(String trialCount) {
        if (Integer.parseInt(trialCount) < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_NUMBER.getErrorMessage());
        }
    }
}
