package racingcar.domain;

import racingcar.random.NumberGenerator;

public class Engine {

    private static final int MINIMUM_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean tryToWork() {
        int value = numberGenerator.generateNumberInRange();
        return value >= MINIMUM_THRESHOLD;
    }
}
