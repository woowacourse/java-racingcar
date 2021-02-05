package racingcar.utils;

import javafx.scene.shape.PathElement;
import racingcar.utils.exception.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidation {
    private static int NAME_MAX_LENGTH = 5;
    private static int CAR_MIN_NUMBER = 2;

    public void validateName(String[] name) {
        isValidText(name);
        isValidLength(name);
        isDuplicateName(name);
        notEnoughCars(name);
    }

    private void notEnoughCars(String[] name) {
        if (name.length < CAR_MIN_NUMBER) {
            throw new NotEnoughCarException(CAR_MIN_NUMBER);
        }
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

    public void validateTime(String input) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, input) || input.equals("0")) {
            throw new InvalidTimeException();
        }
    }
}
