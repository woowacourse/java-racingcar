package utils;

import static utils.RandomPowerGenerator.createRandomPower;

public class RandomMovingEngine implements Engine {
    private final static int MOVE_STANDARD = 4;

    @Override
    public boolean isMovable() {
        if (createRandomPower() >= MOVE_STANDARD)
            return true;

        return false;
    }
}
