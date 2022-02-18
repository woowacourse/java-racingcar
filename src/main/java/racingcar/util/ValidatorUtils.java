package racingcar.util;

import static racingcar.constants.GameConstants.MAX_NAME_LENGTH;
import static racingcar.constants.SystemConstants.NUMBER_ZERO_FOR_POSITIVE_CHECK;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_BLANK_OR_NULL_NOT_ALLOWED;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_DUPLICATE_NAME;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_NOT_POSITIVE_INTEGER;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_OVER_FIVE_CHARACTERS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidatorUtils {

    private ValidatorUtils() {
        throw new AssertionError();
    }

    public static void validatePositiveInt(int integer) {
        if (integer <= NUMBER_ZERO_FOR_POSITIVE_CHECK) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_INTEGER);
        }
    }

    public static void validateCarName(String name) {
        validateNonBlankOrNull(name);
        validateNotOverFiveCharacters(name);
    }

    private static void validateNonBlankOrNull(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_OR_NULL_NOT_ALLOWED);
        }
    }

    private static void validateNotOverFiveCharacters(String string) {
        if (string.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_FIVE_CHARACTERS);
        }
    }

    public static void validateNoDuplicates(String[] strings) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(strings));
        if (strings.length != carNameSet.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }
}
