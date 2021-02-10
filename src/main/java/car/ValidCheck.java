package car;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidCheck {

    private static final int CAR_NAME_LIMIT = 5;

    private ValidCheck() {

    }

    public static void carNameValid(String carNamesInput) {
        if (isSpace(carNamesInput) || isNameLength(carNamesInput)) {
            throw new IllegalArgumentException();
        }
    }

    public static void round(String roundInput) {
        final String pattern = "[1-9]+[0-9]*";
        if (!Pattern.matches(pattern, roundInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSpace(String carNamesInput) {
        return carNamesInput.contains(" ");
    }

    private static boolean isNameLength(String carNamesInput) {
        final String delimiter = ",";
        String[] carNames = carNamesInput.split(delimiter);

        return Arrays.stream(carNames)
            .anyMatch(name -> name.length() > CAR_NAME_LIMIT);
    }


}
