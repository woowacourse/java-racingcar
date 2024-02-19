package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomMoveCondition implements MoveCondition {

    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MINIMUM_MOVEMENT_CONDITION = 4;
    private static RandomMoveCondition instance;

    private RandomMoveCondition() {
    }

    public static RandomMoveCondition getInstance() {
        if(instance == null) {
            instance = new RandomMoveCondition();
        }
        return instance;
    }

    @Override
    public boolean isMovable() {
        return RandomGenerator.generateRandomNumber(MAX_RANDOM_NUMBER + 1) >= MINIMUM_MOVEMENT_CONDITION;
    }
}
