package racingcargame.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomFactory {
    private final static List<Integer> numbers = new ArrayList<>();
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    static {
        for (int element = LOWER_BOUND; element <= UPPER_BOUND; element++) {
            numbers.add(element);
        }
    }

    public static int getRandom() {
        Collections.shuffle(numbers);
        return numbers.get(0);
    }
}
