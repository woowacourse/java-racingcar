package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public void isValidPattern(String input) {
        Pattern pattern = Pattern.compile(Constant.CAR_NAME_PATTERN_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(Constant.NOT_ALPHA_AND_COMMA_ERROR);
        }
    }

    public void isValidLength(String[] names) {
        for (String name : names) {
            checkLength(name);
        }
    }

    private void checkLength(String name) {
        if (name.length() > Constant.MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(Constant.NOT_ALLOW_LENGTH_ERROR);
        }
    }

    public void isDuplicate(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() != names.length) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NAME_ERROR);
        }
    }

    public void isNumeric(String input) {
        Pattern pattern = Pattern.compile(Constant.COIN_PATTERN_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(Constant.NOT_NUMERIC_ERROR);
        }
    }

    public void isNaturalNumber(int input) {
        if (input < Constant.MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(Constant.MINIMUM_NATURAL_NUMBER_ERROR);
        }
    }
}
