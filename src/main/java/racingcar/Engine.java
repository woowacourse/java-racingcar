package racingcar;

import racingcar.random.NumberGenerator;

public class Engine {

    private static final int MINIMUM_THRESHOLD = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final NumberGenerator numberGenerator;
    private boolean isWorking = false;

    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void tryToWork() {
        int value = numberGenerator.generateNumberInRange(MIN_RANGE, MAX_RANGE);
        isWorking = value >= MINIMUM_THRESHOLD;
    }

    public boolean isWorking() {
        return isWorking;
    }
}
