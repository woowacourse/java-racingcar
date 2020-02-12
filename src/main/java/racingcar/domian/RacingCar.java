package racingcar.domian;

import java.util.Random;

public class RacingCar {
    private Random random;

    public RacingCar() {
        random = new Random();
    }

    public int generateRandom() {
        return random.nextInt(10);
    }
}
