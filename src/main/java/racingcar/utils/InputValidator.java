package racingcar.utils;

import java.util.Arrays;

public class InputValidator {

    private static final int LIMIT_NAME_LEN = 5;

    public static void checkValidNames(String[] names) {
        Arrays.stream(names).forEach(InputValidator::checkValidName);
    }

    public static void checkValidName(String name) {
        // isNull 메소드로 빼는 방안
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

    public static int isValidTryCount(String tryCount) {
        if(!isOnlyNumber(tryCount)) {
            throw new IllegalArgumentException("Input is not Number");
        }
        int count = Integer.parseInt(tryCount);
        if(!isPositive(count)) {
            throw new IllegalArgumentException("Input must be positive");
        }
        return count;
    }

    public static boolean isOnlyNumber(String tryCount) {
        for (char c : tryCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPositive(int tryCount) {
        return tryCount > 0;
    }
}
