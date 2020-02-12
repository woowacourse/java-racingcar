package racinggame.race.car.engine;

import java.util.Random;

public class RealEngine implements Engine {
    private static final int BOUND = 10;

    @Override
    public int getPower() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
