package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.function.Predicate;

public class CarMoveRule  {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVE_LIMIT = 3;

    public Predicate<CarMoveRule> getDefaultRule() {
        return (CarMoveRule rule) -> rule.generate() > MOVE_LIMIT;
    }

    public Predicate<CarMoveRule> noMoveRule() {
        return (CarMoveRule rule) -> MIN_NUMBER > MOVE_LIMIT;
    }

    public Predicate<CarMoveRule> alwaysMoveRule() {
        return (CarMoveRule rule) -> MAX_NUMBER >= MOVE_LIMIT;
    }

    public int generate() {
        return RandomNumberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
    }
}
