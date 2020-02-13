package racingcar.domain;

import java.util.Random;

public class Race {
    public static final int VALUE_LIMIT = 10;
    public static final int MOVING_CRITERIA = 4;
    private Random random = new Random();

    public void racing(Car car) {
        int randomValue = getRandomNumber();

        moveAccordingToCondition(car, randomValue);
    }

    protected void moveAccordingToCondition(Car car, int randomValue) {
        if (randomValue >= MOVING_CRITERIA) {
            car.moveForward();
        }
    }

    private int getRandomNumber() {
        return random.nextInt(VALUE_LIMIT);
    }
}
