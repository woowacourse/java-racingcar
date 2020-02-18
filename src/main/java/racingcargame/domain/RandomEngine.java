package racingcargame.domain;

import racingcargame.util.RandomFactory;

public class RandomEngine implements Engine {
    private static final int LIMIT = 4;

    private int power;

    public RandomEngine() {
        this.power = RandomFactory.getRandom();
    }

    public void setPowerToRandomValue() {
        this.power = RandomFactory.getRandom();
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean isMovable() {
        return LIMIT <= power;
    }
}
