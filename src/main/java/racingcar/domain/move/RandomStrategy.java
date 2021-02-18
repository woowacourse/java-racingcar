package racingcar.domain.move;

import racingcar.utils.RandomNumberGenerator;

public class RandomStrategy implements MoveStrategy {

    public RandomStrategy() {
    }

    @Override
    public int getCriteria() {
        return RandomNumberGenerator.turnNumber();
    }
}
