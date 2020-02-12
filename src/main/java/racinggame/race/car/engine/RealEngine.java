package racinggame.race.car.engine;

import java.util.Random;

public class RealEngine implements Engine {
    private static final int BOUND = 10;
    private static final int MINIMUM = 4;

    @Override
    public boolean enoughPower() {
        return enough(new Random());
    }

    private boolean enough(Random random) {
        return random.nextInt(BOUND) > MINIMUM;
    }
}
