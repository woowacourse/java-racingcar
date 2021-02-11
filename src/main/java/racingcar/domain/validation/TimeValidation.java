package racingcar.domain.validation;

import racingcar.utils.exception.InvalidTimeException;

import java.util.regex.Pattern;

public class TimeValidation {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    private TimeValidation() {
    }

    public static void validateTime(String value) {
        if (value.equals("0") || !NUMBER_PATTERN.matcher(value).matches()) {
            throw new InvalidTimeException();
        }
    }
}
