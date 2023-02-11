package racingcar.domain;

import static racingcar.domain.Name.Validator.*;
import static racingcar.exception.ExceptionMessage.*;

import java.util.Arrays;

public class Name {
    private final String value;

    public Name(String value) {
        validateBlankName(value);
        validateNameLength(value);
        this.value = value;
    }

    public static class Validator {
        private static final int MAX_NAME_LENGTH = 6;

        private Validator() {
        }

        public static void validateBlankName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
            }
        }

        public static void validateNameLength(String name) {
            if (name.length() >= MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
            }
        }

        public static void validateDuplicateNames(String[] names) {
            long noDuplicateCount = Arrays.stream(names)
                    .distinct()
                    .count();
            if (noDuplicateCount != names.length) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }

    public String getValue() {
        return value;
    }
}
