package racingcar.domain.movement;

import racingcar.utils.RandomNumberGenerator;

public class RandomMovementStrategy implements MovementStrategy {

    private static final int THRESHOLD = 4;
    private static final int DISTANCE = 1;

    @Override
    public int move() {
        int random = RandomNumberGenerator.generate();
        if (isMovable(random)) {
            return DISTANCE;
        }
        return 0;
    }

    private boolean isMovable(int random) {
        return random >= THRESHOLD;
    }
}
