package racingcar.util;

import java.util.Random;

public class RandomUtil {

    private static final int RANGE_FOR_CAR = 10;

    private static Random random = new Random();

    public static int getRandomForCar() {
        return random.nextInt(RANGE_FOR_CAR);
    }
}
