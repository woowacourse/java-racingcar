package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static racingcar.constants.OutputMessages.BLANK_NOT_ALLOWED_EXCEPTION;
import static racingcar.constants.OutputMessages.DUPLICATE_NAME_EXCEPTION;
import static racingcar.constants.OutputMessages.NOT_POSITIVE_INTEGER_EXCEPTION;
import static racingcar.constants.OutputMessages.OVER_FIVE_CHARACTERS_EXCEPTION;
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
            throw new RuntimeException(NOT_POSITIVE_INTEGER_EXCEPTION);
        }
    }

    public static String[] splitAndValidateCarNames(String carNamesString) {
        String[] carNames = Optional.of(carNamesString.split(COMMA)).orElseThrow(RuntimeException::new);

        for (String name : carNames) {
            validateNotBlank(name);
            validateNotOverFiveCharacters(name);
        }
        validateNoDuplicates(carNames);

        return carNames;
    }

    private static void validateNotBlank(String string) {
        if (string.trim().isEmpty()) {
            throw new RuntimeException(BLANK_NOT_ALLOWED_EXCEPTION);
        }
    }

    private static void validateNotOverFiveCharacters(String string) {
        if (string.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(OVER_FIVE_CHARACTERS_EXCEPTION);
        }
    }

    private static void validateNoDuplicates(String[] strings) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(strings));
        if (strings.length != carNameSet.size()) {
            throw new RuntimeException(DUPLICATE_NAME_EXCEPTION);
        }
    }
}
