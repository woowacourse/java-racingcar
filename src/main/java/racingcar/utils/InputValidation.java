package racingcar.utils;

import racingcar.utils.exception.DuplicateNameException;
import racingcar.utils.exception.InvalidNameLengthException;
import racingcar.utils.exception.InvalidTextException;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidation {
    private static int NAME_MAX_LENGTH = 5;

    public void validateName(String[] name) {
        isValidText(name);
        isValidLength(name);
        isDuplicateName(name);
    }

    private void isDuplicateName(String[] name) {
        if (!equalsNameLength(name)) {
            throw new DuplicateNameException();
        }
    }

    private boolean equalsNameLength(String[] name) {
        return Arrays.stream(name)
                .distinct()
                .count() == name.length;
    }

    private void isValidLength(String[] names) {
        Arrays.stream(names)
                .filter(name -> checkLength(name))
                .findAny()
                .ifPresent(s -> {
                    throw new InvalidNameLengthException(NAME_MAX_LENGTH);
                });
    }

    private boolean checkLength(String name) {
        return name.length() <= 0 || name.length() > NAME_MAX_LENGTH;
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
