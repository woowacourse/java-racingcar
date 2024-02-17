package racingcar.view.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    
    public static void validateAvailableName(List<String> names){
        for(String inputName :  names){
            hasSpaceInName(inputName);
            isAvailableLength(inputName);
        }
    }

    public static void validateIsBlank(String input) {
        if(input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
    private static void hasSpaceInName(String name) {
        if(name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private static void isAvailableLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAvailableCarNames(List<String> carNames){
        validateIsMultipleCarNames(carNames);
        validateIsDuplicate(carNames);
    }

    private static void validateIsMultipleCarNames(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsDuplicate(List<String> inputs) {
        Set<String> nameSet = new HashSet<>(inputs);

        if(nameSet.size() != inputs.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTryNumber(String tryNumber) {
        try {
            validateIsNumeric(tryNumber);
            validateIsPositive(tryNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsNumeric(String tryNumber) {
        if(!tryNumber.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsPositive(String tryNumber) {
        if(Integer.parseInt(tryNumber) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
