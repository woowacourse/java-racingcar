package racingcar.service;

import java.util.Random;

public class RandomNumberOverThanFour implements Movement {
    private static final int NUMBER_POSSIBLE_TO_MOVE = 4;
    private static final int MAX_RANDOM_NUMBER_BOUNDARY = 10;

    private final Random random = new Random();

    public boolean move() {
        final int randomNumber = random.nextInt(MAX_RANDOM_NUMBER_BOUNDARY);
        return randomNumber >= NUMBER_POSSIBLE_TO_MOVE;
    }
}
