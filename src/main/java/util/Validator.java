package util;

import message.Constant;
import message.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private static final int CAR_NAME_EMPTY = 0;

    public static void validateCarNames(String carNames) {
        validateCarNameInputEmpty(carNames);
        validateLastCharacterOfCarNameInputIsDelimiter(carNames);
        List<String> carNamesForValidation = trimCarNames(List.of(carNames.split(Constant.DELIMITER)));
        validateCarNameOutOfLength(carNamesForValidation);
        validateCarNameHasDuplicate(carNamesForValidation);
    }

    public static void validateNumberOfTimes(String input) {
        nonNumber(input);
        int number = Integer.parseInt(input);

        if (number <= Constant.NUMBER_OF_TIME_LOWER_BOUND || Constant.NUMBER_OF_TIME_UPPER_BOUND <= number) {
            throw new IllegalArgumentException(Error.NUMBER_OF_TIME_ERROR);
        }
    }

    private static List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateCarNameInputEmpty(String carNames) {
        if (carNames.length() == CAR_NAME_EMPTY) {
            throw new IllegalArgumentException(Error.EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateLastCharacterOfCarNameInputIsDelimiter(String carNames) {
        String lastCharacterOfCarNameInput = Character.toString(carNames.charAt(carNames.length() - 1));
        if (lastCharacterOfCarNameInput.equals(Constant.DELIMITER)) {
            throw new IllegalArgumentException(Error.EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateCarNameOutOfLength(List<String> carNames) {
        if (isNotCorrectLength(carNames)) {
            throw new IllegalArgumentException(Error.EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static boolean isNotCorrectLength(List<String> carNames) {
        return !carNames.stream()
                .allMatch(carName ->
                        Constant.CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE <= carName.length()
                                && carName.length() <= Constant.CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE);
    }

    private static void validateCarNameHasDuplicate(List<String> carName) {
        Set<String> duplicateChecker = new HashSet<>(carName);

        if (duplicateChecker.size() != carName.size()) {
            throw new IllegalArgumentException(Error.EXISTS_DUPLICATE_CAR_NAME_ERROR);
        }
    }

    private static void nonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Error.NON_INTEGER_ERROR);
        }
    }
}
