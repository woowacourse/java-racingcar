package racinggame.domain;

import java.util.Random;

public class RacingGame implements Strategy {
    public static final int NUMBER_BOUND = 10;

    public static int generateRandom() {
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        return rand.nextInt(NUMBER_BOUND);
    }

    public int moveCars(Cars cars, int maxPosition) {
        for (Car car : cars) {
            if (car.move(generateRandom())) {
                maxPosition = car.getMaxPosition(maxPosition);
            }
        }
        return maxPosition;
    }
}
