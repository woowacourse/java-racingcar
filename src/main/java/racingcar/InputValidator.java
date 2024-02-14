package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    
    public void validateAvailableName(List<String> parsedInputs){
        for(String inputName : parsedInputs){
            hasSpaceInName(inputName);
            isAvailableLength(inputName);
        }
    }

    public void validateIsBlank(String initialInput) {
        if(initialInput.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
    private void hasSpaceInName(String inputName) {
        if(inputName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void isAvailableLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }



    public void validateAvailableCarNames(List<String> parsedCarNames){
        validateIsMultipleCarNames(parsedCarNames);
        validateIsDuplicate(parsedCarNames);
    }

    private void validateIsMultipleCarNames(List<String> parsedInputs) {
        if (parsedInputs.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsDuplicate(List<String> parsedInputs) {
        Set<String> nameSet = new HashSet<>(parsedInputs);

        if(nameSet.size() != parsedInputs.size()) {
            throw new IllegalArgumentException();
        }
    }
}
