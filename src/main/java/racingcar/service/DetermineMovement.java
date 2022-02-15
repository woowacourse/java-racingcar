package racingcar.service;

import java.util.Random;

public class DetermineMovement implements MoveOrStop {
    private static final int MOVE_CRITERION = 4;
    private static final int MAX_RANDOM_NUMBER_BOUNDARY = 10;

    private final Random random = new Random();

    public boolean determine() {
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER_BOUNDARY);

        if (judgeToMove(randomNumber)) {
            return true;
        }
        return false;
    }

    private boolean judgeToMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERION;
    }
}
