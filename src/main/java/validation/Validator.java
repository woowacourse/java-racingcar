package validation;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MIN_TRIAL_COUNT = 1;
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public static void validateCarName(List<String> carNames) {
        checkCarName(carNames);
    }

    public static void validateTrialCount(String trialCount) {
        checkDigit(trialCount);
        checkTrialCount(trialCount);
    }

    private static void checkCarName(List<String> carNames) {
        if (hasWrongSizeName(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_NAME.getErrorMessage());
        }
    }

    private static boolean hasWrongSizeName(List<String> carNames) {
        return carNames.stream()
                .filter(carName -> isWrongSize(carName))
                .findFirst()
                .isPresent();
    }

    private static boolean isWrongSize(String carName) {
        return carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH;
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
