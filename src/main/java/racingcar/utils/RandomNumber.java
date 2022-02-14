package racingcar.utils;

import java.util.Random;

public class RandomNumber {

    private static final int END_EXCLUSIVE = 10;

    public static int generate() {
        return new Random().nextInt(END_EXCLUSIVE);
    }
}
