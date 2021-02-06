package racingcar.validator;

import java.util.Arrays;

public class NameValidator {
    private static final int LIMIT_NAME_LEN = 5;

    public static void checkValidName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }

        if (!isValidLength(name)) {
            throw new IllegalArgumentException("Invalid name length exception");
        }
    }

    private static boolean isValidLength(String name) {
        return name.trim().length() <= LIMIT_NAME_LEN && name.trim().length() > 0;
    }

    public static void isDuplicatedNames(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("Duplicated Name exception");
        }
    }
}
