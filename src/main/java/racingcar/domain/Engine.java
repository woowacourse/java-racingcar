package racingcar.domain;

import racingcar.random.NumberGenerator;

public class Engine {

    private static final int MINIMUM_THRESHOLD = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final NumberGenerator numberGenerator;

    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean tryToWork() {
        int value = numberGenerator.generateNumberInRange(MIN_RANGE, MAX_RANGE);
        return value >= MINIMUM_THRESHOLD;
    }
}
