package racing.domain;

import racing.util.RandomGenerator;

public class RandomMoveStrategy implements MoveStrategy {


    private static final int MIN_MOVABLE_NUMBER = 4;

    @Override
    public boolean movable() {
        return RandomGenerator.generate() >= MIN_MOVABLE_NUMBER;
    }
}
