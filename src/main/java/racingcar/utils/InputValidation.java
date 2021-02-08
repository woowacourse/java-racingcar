package racingcar.utils;

import racingcar.utils.exception.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidation {
    private static int CAR_MIN_NUMBER = 2;

    private InputValidation() {
    }

    public static void validateName(String[] name) {
        isValidText(name);
        isDuplicateName(name);
        notEnoughCars(name);
    }

    private static void notEnoughCars(String[] name) {
        if (name.length < CAR_MIN_NUMBER) {
            throw new NotEnoughCarException(CAR_MIN_NUMBER);
        }
    }

    private static void isDuplicateName(String[] name) {
        if (!equalsNameLength(name)) {
            throw new DuplicateNameException();
        }
    }

    private static boolean equalsNameLength(String[] name) {
        return Arrays.stream(name)
                .distinct()
                .count() == name.length;
    }

    private static void isValidText(String[] names) {
        String pattern = "^[a-zA-Z가-힣0-9]*$";
        Arrays.stream(names)
                .filter(name -> !Pattern.matches(pattern, name))
                .findAny()
                .ifPresent(s -> {
                    throw new InvalidTextException();
                });
    }

    public static void validateTime(String input) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, input) || input.equals("0")) {
            throw new InvalidTimeException();
        }
    }
}
