package validation;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";

    public static void validateCarName(List<String> carNames) {
        checkCarName(carNames);
    }

    public static void validateTrialCount(String trialCount) {
        checkDigit(trialCount);
    }

    private static void checkCarName(List<String> carNames) {
        if (hasWrongName(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_CAR_NAME.getMessage());
        }
    }

    private static boolean hasWrongName(List<String> carNames) {
        return carNames.stream()
                .anyMatch(InputValidator::isWrongName);
    }

    private static boolean isWrongName(String carName) {
        return carName.isEmpty() || carName.isBlank();
    }

    private static void checkDigit(String input) {
        if (!Pattern.matches(DIGIT_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TRIAL_NUMBER.getMessage());
        }
    }
}
