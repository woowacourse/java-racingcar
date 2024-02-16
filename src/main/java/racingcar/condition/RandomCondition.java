package racingcar.condition;

import racingcar.domain.RandomGenerator;

public class RandomCondition implements MovingCarCondition {
    @Override
    public boolean isSatisfied() {
        int number = RandomGenerator.getRandomNumberUnder(10);
        return number >= 4;
    }
}
