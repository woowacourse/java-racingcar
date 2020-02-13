package racingcargame.domain;

import racingcargame.util.RandomFactory;

public class Engine {
    private static final int LIMIT = 4;
    private int power;

    private Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public static Engine createRandomEngine() {
        int power = RandomFactory.getRandom();
        return new Engine(power);
    }

    public static Engine createEngineSetBy(int power) {
        return new Engine(power);
    }

    public boolean isHigherThanLimit() {
        return LIMIT <= power;
    }
}
