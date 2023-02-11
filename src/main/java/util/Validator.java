package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Validator {

    private static final int CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;
    private static final int NUMBER_OF_TIME_LOWER_BOUND_INCLUSIVE = 0;
    private static final int NUMBER_OF_TIME_UPPER_BOUND_INCLUSIVE = 101;
    private static final int CAR_NAME_INPUT_EMPTY = 0;

    private static final String NON_INTEGER_ERROR = "숫자만 입력 가능합니다.";
    private static final String EXCEEDED_CAR_NAME_LENGTH_ERROR = "자동차명은 1 ~ 5 글자로 입력해야합니다.";
    private static final String NUMBER_OF_TIME_RANGE_ERROR = "1 ~ 100 사이의 숫자를 입력해주세요";
    private static final String EXISTS_DUPLICATE_CAR_NAME_ERROR = "자동차명은 중복되어선 안됩니다.";

    public static void validateCarNames(String carNames) {
        validateCarNameInputEmpty(carNames);
        validateLastCharacterOfCarNameInputIsDelimiter(carNames);

        List<String> carNamesForValidation = trimCarNames(List.of(
                carNames.split(
                        Constant.DELIMITER
                )
        ));
        validateCarNameOutOfLength(carNamesForValidation);
        validateCarNameHasDuplicate(carNamesForValidation);
    }

    public static void validateNumberOfTimes(String input) {
        nonInteger(input);
        int number = Integer.parseInt(input);

        if (number <= NUMBER_OF_TIME_LOWER_BOUND_INCLUSIVE || NUMBER_OF_TIME_UPPER_BOUND_INCLUSIVE <= number) {
            throw new IllegalArgumentException(NUMBER_OF_TIME_RANGE_ERROR);
        }
    }

    private static List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(toList());
    }

    private static void validateCarNameInputEmpty(String carNames) {
        if (carNames.length() == CAR_NAME_INPUT_EMPTY) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateLastCharacterOfCarNameInputIsDelimiter(String carNames) {
        String lastCharacterOfCarNameInput = Character.toString(carNames.charAt(carNames.length() - 1));

        if (lastCharacterOfCarNameInput.equals(Constant.DELIMITER)) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateCarNameOutOfLength(List<String> carNames) {
        if (isNotCorrectLength(carNames)) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static boolean isNotCorrectLength(List<String> carNames) {
        return !carNames.stream()
                .allMatch(
                        carName -> CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE <= carName.length()
                                && carName.length() <= CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE);
    }

    private static void validateCarNameHasDuplicate(List<String> carName) {
        Set<String> duplicateChecker = new HashSet<>(carName);

        if (duplicateChecker.size() != carName.size()) {
            throw new IllegalArgumentException(EXISTS_DUPLICATE_CAR_NAME_ERROR);
        }
    }

    private static void nonInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR);
        }
    }
}
