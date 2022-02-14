package racingCar.model.utlis;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import racingCar.model.exception.count.CountNotNumberException;

public class Util {
    private static final String NAME_REGEX = ",";
    private static final int RANDOM_MAX_BOUND_INTEGER = 10;
    private static final String INTEGER_REGEX = "[0-9]+";

    public static int getRandomInteger() {
        return new Random().nextInt(RANDOM_MAX_BOUND_INTEGER);
    }

    public static int getMax(List<Integer> integers) {
        return Collections.max(integers);
    }

    public static String[] separate(String text) {
        return text.split(NAME_REGEX);
    }

    public static int convertToInteger(String count) {
        if (!Pattern.matches(INTEGER_REGEX, count)) {
            throw new CountNotNumberException();
        }
        return Integer.parseInt(count);
    }
}