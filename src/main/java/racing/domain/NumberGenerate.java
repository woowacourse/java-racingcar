package racing.domain;

import racing.util.RandomNumberGenerator;

public class NumberGenerate implements MovementStrategy {
    public int numberGenerate() {
        return RandomNumberGenerator.generate(Car.MAX_RANDOM_NUM_UPPER_BOUND);
    }
}
