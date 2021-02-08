package racing.domain;

import racing.utils.RandomUtils;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int MINIMUM_MOVE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        int randomNumber = RandomUtils.getRandomNumber(START_NUMBER, END_NUMBER);
        return randomNumber >= MINIMUM_MOVE_NUMBER;
    }
}
