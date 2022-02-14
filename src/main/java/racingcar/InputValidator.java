package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {


    private static final int MINIMUM_NATURAL_NUMBER = 1;

    private static final String COIN_PATTERN_REGEX = "^[0-9]*$";

    private static final Pattern pattern = Pattern.compile(COIN_PATTERN_REGEX);

    public void isNumeric(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(Constant.NOT_NUMERIC_ERROR);
        }
    }

    public void isNaturalNumber(int input) {
        if (input < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(Constant.MINIMUM_NATURAL_NUMBER_ERROR);
        }
    }
}
