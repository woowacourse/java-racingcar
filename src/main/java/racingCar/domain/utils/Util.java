package racingCar.domain.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import racingCar.domain.exception.count.CountNotNumberException;

public class Util {
    private static final String NAME_REGEX = ",";
    private static final int RANDOM_MAX_BOUND_NUM = 10;
    private static final String NUM_REGEX = "[0-9]+";

    public static int getRandomInteger() {
        return new Random().nextInt(RANDOM_MAX_BOUND_NUM);
    }

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