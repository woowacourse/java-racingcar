package racingcar.validator;

import static racingcar.exception.ExceptionMessage.*;

import java.util.Arrays;

public class Validator {
    private static final int MAX_NAME_LENGTH = 6;

    private Validator() {}

    public static void validateNegativeTryCount(Integer tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    public static void validateDuplicateCarNames(String[] names) {
        long noDuplicateCount = Arrays.stream(names)
                .distinct()
                .count();
        if (noDuplicateCount != names.length) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public static void validateEmptyCarName(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
        }
    }

    public static void validateCarNameLength(String name) {
        if(name.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
        }
    }
}
