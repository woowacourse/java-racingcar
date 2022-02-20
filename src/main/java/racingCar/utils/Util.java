package racingCar.utils;

import java.util.regex.Pattern;
import racingCar.exception.count.CountNotNumberException;

public class Util {
    private static final String NAME_REGEX = ",";
    private static final String NUM_REGEX = "[0-9]+";

    public static String[] separate(String text) {
        return text.split(NAME_REGEX);
    }

    public static int convertToInteger(String count) {
        if (!Pattern.matches(NUM_REGEX, count)) {
            throw new CountNotNumberException();
        }
        return Integer.parseInt(count);
    }
}