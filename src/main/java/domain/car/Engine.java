package domain.car;

import java.util.Random;

public class Engine implements MovableStrategy {
    private static final int POWER_LIMIT = 10;
    private final int power;

    public Engine() {
        this.power = new Random().nextInt(POWER_LIMIT);
    }

    @Override
    public boolean isMove() {
        return power >= FORWARD_THRESHOLD;
    }

}
