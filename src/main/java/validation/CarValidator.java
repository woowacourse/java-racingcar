package validation;

import java.util.List;

public class CarValidator {

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static ValidateResult validate(final String carName) {
        if (!isProperLength(carName)) {
            return ValidateResult.FAIL_INVALID_LENGTH;
        }
        if (containsInvalidWord(carName)) {
            return ValidateResult.FAIL_CONTAIN_IDENTIFIER;
        }
        return ValidateResult.SUCCESS;
    }

    private static boolean isProperLength(final String carName) throws IllegalArgumentException {
        return carName != null && carName.length() >= MIN_CAR_NAME_LENGTH && carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private static boolean containsInvalidWord(final String carName) {
        final List<String> invalidWords = List.of("-");
        return invalidWords.stream().anyMatch(carName::contains);
    }
}
