package racinggame.domain;

import java.util.Random;

import static racinggame.domain.RacingGame.NUMBER_BOUND;

public class RandomGenerator implements Strategy {

    public int generateRandom() {
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        return rand.nextInt(NUMBER_BOUND);
    }
}
