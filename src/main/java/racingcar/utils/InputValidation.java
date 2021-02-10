package racingcar.utils;

import racingcar.utils.exception.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidation {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int CAR_MIN_NUMBER = 2;
    private static final Pattern VALID_TEXT_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]*$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final String ZERO_TIME = "0";

    private InputValidation() {}

    public static void validateCars(String[] name) {
        isDuplicateName(name);
        notEnoughCars(name);
    }

    public static void validateCarName(String name) {
        isValidText(name);
        isValidLength(name);
    }

    public static void validateTime(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches() || input.equals(ZERO_TIME)) {
            throw new InvalidTimeException();
        }
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

    private static void isValidLength(String name) {
        if (checkLength(name)) {
            throw new InvalidNameLengthException(NAME_MAX_LENGTH);
        }
    }

    private static boolean checkLength(String name) {
        return name.length() <= 0 || name.length() > NAME_MAX_LENGTH;
    }

    private static void isValidText(String name) {
        if (!VALID_TEXT_PATTERN.matcher(name).matches()) {
            throw new InvalidTextException();
        }
    }
}
