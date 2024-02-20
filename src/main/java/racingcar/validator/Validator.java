package racingcar.validator;

import java.util.List;

import static racingcar.message.ErrorMessage.*;

public class Validator {
    private final static int MAXIMUM_NAME_LENGTH = 5;

    public static void validateNaturalNumber(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(MESSAGE_ONLY_NATURAL_NUMBER.getMessage());
        }
    }

    public static void validateNoDuplicatedCarNames(List<String> splitCarNames) {
        long distinctCarCount = splitCarNames.stream()
                .distinct()
                .count();
        if (distinctCarCount != splitCarNames.size()) {
            throw new IllegalArgumentException(MESSAGE_NO_DUPLICATE_CAR_NAMES.getMessage());
        }
    }

    public static void validateLengthOfCarNames(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            validateLengthOfCarName(carName);
        }
    }

    public static void validateLengthOfCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_LENGTH_OF_CAR_NAME.getMessage());
        }
    }

    public static void validateNoSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(MESSAGE_NO_SPACE.getMessage());
        }
    }
}
