package racingcargame.domain;

import racingcargame.util.RandomFactory;

public class Engine {
    private int power;

    private Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public static Engine getRandom() {
        int power = RandomFactory.getRandom();
        return new Engine(power);
    }

    public static Engine createEngineSetBy(int power) {
        return new Engine(power);
    }
}
