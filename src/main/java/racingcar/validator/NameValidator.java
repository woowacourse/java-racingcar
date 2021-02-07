package racingcar.validator;

public class NameValidator {
    private static final int LIMIT_NAME_LEN = 5;

    public static void checkIsValid(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }

        if (!isValidLength(name)) {
            throw new IllegalArgumentException("Invalid name length exception");
        }
    }

    private static boolean isValidLength(final String name) {
        return name.trim().length() <= LIMIT_NAME_LEN && name.trim().length() > 0;
    }
}
