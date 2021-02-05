package racingcar.utils;

import racingcar.utils.exception.InvalidTextException;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidation {

    public void validateName(String[] name) {
        isValidText(name);
    }

    private void isValidText(String[] names) {
        String pattern = "^[a-zA-Z가-힣0-9]*$";
        Arrays.stream(names)
                .filter(name -> !Pattern.matches(pattern, name))
                .findAny()
                .ifPresent(s -> {
                    throw new InvalidTextException();
                });
    }
}
