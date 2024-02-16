package racingcar.domain.move;

import racingcar.domain.generator.NumberGenerator;

public class DefaultMovingStrategy implements MovingStrategy {
    private static final int MOVING_THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public DefaultMovingStrategy(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.generate() >= MOVING_THRESHOLD;
    }
}
