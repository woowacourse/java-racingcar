package racingcar.domain.Rule;

import racingcar.domain.RandomNumberGenerator;

public class MoveRule extends Rule {
    private static final int RANDOM_NUMBER_BOUND = 9;
    private static final int RANDOM_NUMBER_LOWER_BOUND = 1;
    private static final int MOVEMENT_CRITERIA = 4;

    public MoveRule() {
        this(RandomNumberGenerator.generateRandomNumber(RANDOM_NUMBER_BOUND, RANDOM_NUMBER_LOWER_BOUND));
    }

    public MoveRule(int number) {
        if (number >= MOVEMENT_CRITERIA) {
            super.canMove = true;
        }
    }
}
