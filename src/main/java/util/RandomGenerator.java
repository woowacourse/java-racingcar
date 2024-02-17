package util;

import static util.Constants.MAX_RANDOM_NUMBER;
import static util.Constants.MIN_RANDOM_NUMBER;

public class RandomGenerator {

    public static int pickRandomNumber() {
        return (int) (Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER));
    }

}
