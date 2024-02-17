package racingcar.view.validator;

import static racingcar.view.ErrorMessage.ERROR_WITH_CONTAIN_BLANK;
import static racingcar.view.ErrorMessage.ERROR_WITH_DUPLICATE_NAME;
import static racingcar.view.ErrorMessage.ERROR_WITH_INPUT_BLANK;
import static racingcar.view.ErrorMessage.ERROR_WITH_NON_NUMERIC;
import static racingcar.view.ErrorMessage.ERROR_WITH_ONLY_ONE_CAR;
import static racingcar.view.ErrorMessage.ERROR_WITH_OVER_LENGTH;
import static racingcar.view.ErrorMessage.ERROR_WITH_UNDER_MINIMUM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_CAR_COUNT = 2;
    private static final int MIN_TRY_NUMBER = 1;
    
    public static void validateAvailableName(List<String> names){
        for(String inputName :  names){
            hasSpaceInName(inputName);
            isAvailableLength(inputName);
        }
    }

    public static void validateIsBlank(String input) {
        if(input.isBlank()) {
            throw new IllegalArgumentException(ERROR_WITH_INPUT_BLANK);
        }
    }
    private static void hasSpaceInName(String name) {
        if(name.contains(" ")) {
            throw new IllegalArgumentException(ERROR_WITH_CONTAIN_BLANK);
        }
    }

    private static void isAvailableLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_WITH_OVER_LENGTH);
        }
    }

    public static void validateAvailableCarNames(List<String> carNames){
        validateIsMultipleCarNames(carNames);
        validateIsDuplicate(carNames);
    }

    private static void validateIsMultipleCarNames(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ERROR_WITH_ONLY_ONE_CAR);
        }
    }

    private static void validateIsDuplicate(List<String> inputs) {
        Set<String> nameSet = new HashSet<>(inputs);

        if(nameSet.size() != inputs.size()) {
            throw new IllegalArgumentException(ERROR_WITH_DUPLICATE_NAME);
        }
    }

    public static void validateTryNumber(String tryNumber) {
        try {
            validateIsNumeric(tryNumber);
            validateIsOverMinimum(tryNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsNumeric(String tryNumber) {
        if(!tryNumber.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_WITH_NON_NUMERIC);
        }
    }

    private static void validateIsOverMinimum(String tryNumber) {
        if(Integer.parseInt(tryNumber) < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(ERROR_WITH_UNDER_MINIMUM);
        }
    }
}
