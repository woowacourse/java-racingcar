package domain.validator;

import validation.ErrorMessage;

import java.util.regex.Pattern;

public class GameTrialCountValidator {

    private static final int MIN_TRIAL_COUNT = 1;
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public static void validateTrialCount(String trialCount) {
        checkDigit(trialCount);
        checkTrialCount(trialCount);
    }

    private static void checkDigit(String input) {
        if (!Pattern.matches(DIGIT_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_NUMBER.getErrorMessage());
        }
    }

    private static void checkTrialCount(String trailCount) {
        if (Integer.parseInt(trailCount) < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_NUMBER.getErrorMessage());
        }
    }
}
