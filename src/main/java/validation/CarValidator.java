package validation;

public class CarValidator {

    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;

    public static ValidateResult validate(final String carName) {
        if (!isProperLength(carName)) {
            return ValidateResult.FAIL_INVALID_LENGTH;
        }
        if (containsIdentifier(carName)) {
            return ValidateResult.FAIL_CONTAIN_IDENTIFIER;
        }
        return ValidateResult.SUCCESS;
    }

    private static boolean isProperLength(final String carName) throws IllegalArgumentException {
        return carName != null && carName.length() >= MIN_CAR_NAME_LENGTH && carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private static boolean containsIdentifier(final String carName) {
        final String IDENTIFIER = "-";
        return carName.contains(IDENTIFIER);
    }
}
