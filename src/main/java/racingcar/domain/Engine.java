package racingcar.domain;

import racingcar.random.NumberGenerator;

public class Engine {

    private static final int MINIMUM_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;
    private boolean isWorking = false;

    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void tryToWork() {
        int value = numberGenerator.generate();
        isWorking = value >= MINIMUM_THRESHOLD;
    }

    public boolean isWorking() {
        return isWorking;
    }
}
