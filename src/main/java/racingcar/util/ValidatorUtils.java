package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static racingcar.constants.OutputMessages.ERROR_BLANK_NOT_ALLOWED;
import static racingcar.constants.OutputMessages.ERROR_DUPLICATE_NAME;
import static racingcar.constants.OutputMessages.ERROR_NOT_POSITIVE_INTEGER;
import static racingcar.constants.OutputMessages.ERROR_NULL;
import static racingcar.constants.OutputMessages.ERROR_OVER_FIVE_CHARACTERS;
import static racingcar.constants.SystemConstants.COMMA;
import static racingcar.constants.SystemConstants.MAX_NAME_LENGTH;
import static racingcar.constants.SystemConstants.ZERO;

public class ValidatorUtils {

    public static int validateAndParsePositiveInt(String string) {
        int integer = Integer.parseInt(string);
        validatePositiveInt(integer);
        return integer;
    }

    private static void validatePositiveInt(int integer) {
        if (integer <= ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_INTEGER);
        }
    }

    public static String[] splitAndValidateCarNames(String carNamesString) {
        String[] carNames = splitWithNullChecking(carNamesString);

        for (String name : carNames) {
            validateNotBlank(name);
            validateNotOverFiveCharacters(name);
        }
        validateNoDuplicates(carNames);

        return carNames;
    }

    private static String[] splitWithNullChecking(String carNamesString) {
        return Optional.of(carNamesString.split(COMMA)).orElseThrow(() -> {
            throw new NullPointerException(ERROR_NULL);
        });
    }

    private static void validateNotBlank(String string) {
        if (string.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_NOT_ALLOWED);
        }
    }

    private static void validateNotOverFiveCharacters(String string) {
        if (string.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_FIVE_CHARACTERS);
        }
    }

    private static void validateNoDuplicates(String[] strings) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(strings));
        if (strings.length != carNameSet.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }
}
