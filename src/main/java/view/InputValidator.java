package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public void validateNames(final String input) {
        List<String> names = generateNames(input);
        validateNamesLength(names);
    }

    private List<String> generateNames(final String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateNamesLength(final List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("차의 이름은 1자 이상 ~ 5자 이하여야 합니다.");
        }
    }
}
