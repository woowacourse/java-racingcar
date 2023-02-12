package racingcar.util;

import java.util.Random;

public class RandomIntGenerator implements IntGenerator {

    private static final int MINIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE = 0;
    private static final int MAXIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE = 9;

    private final Random random;

    public RandomIntGenerator() {
        this.random = new Random();
    }

    public int getOneNumber() {
        return random.ints(MINIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE, (MAXIMUM_BOUNDARY_NUMBER_DETERMINING_MOVE + 1))
                .findFirst()
                .getAsInt();
    }
}
