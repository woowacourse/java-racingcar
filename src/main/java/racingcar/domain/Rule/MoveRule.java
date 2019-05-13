package racingcar.domain.Rule;

import racingcar.domain.RandomNumberGenerator;

public class MoveRule implements Rule {
    private static final int RANDOM_NUMBER_BOUND = 9;
    private static final int RANDOM_NUMBER_LOWER_BOUND = 1;
    private static final int MOVEMENT_CRITERIA = 4;

    public boolean canMove() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber(RANDOM_NUMBER_BOUND, RANDOM_NUMBER_LOWER_BOUND);

        return canMove(randomNumber);
    }

    public boolean canMove(int number) {
        return number >= MOVEMENT_CRITERIA;
    }
}
