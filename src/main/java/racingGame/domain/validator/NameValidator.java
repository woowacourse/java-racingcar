package racingGame.domain.validator;

public class NameValidator {
    private static final int LIMIT_NAME_MAX = 5;
    private static final int LIMIT_NAME_MIN = 1;

    private NameValidator() {
    }

    public static void checkIsValid(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }

        if (!isValidLength(name)) {
            throw new IllegalArgumentException("Invalid name length exception");
        }
    }

    private static boolean isValidLength(final String name) {
        return name.trim().length() <= LIMIT_NAME_MAX && name.trim().length() >= LIMIT_NAME_MIN;
    }
}
