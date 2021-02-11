package racingGame.domain.validator;

import racingGame.domain.racingCar.Name;

import java.util.List;
import java.util.Objects;

public class InputValidator {
    private static final int MINIMUM_NAMES_SIZE = 2;

    private InputValidator() {
    }

    public static void checkIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Enter numeric value");
        }
    }

    public static void checkIsValidInputNames(final List<Name> inputNames) {
        if (Objects.isNull(inputNames)) {
            throw new IllegalArgumentException("Names can't be null");
        }

        if (inputNames.size() < MINIMUM_NAMES_SIZE) {
            throw new IllegalArgumentException("There must be at least two names on input names");
        }
    }
}
