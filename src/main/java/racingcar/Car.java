package racingcar;

import java.util.Random;

public class Car {
    private static final int CAR_MOVE_CONDITION = 4;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final Random random = new Random();

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot() {
        if (random.nextInt(MAX_RANDOM_NUMBER + 1) >= CAR_MOVE_CONDITION) {
            ++position;
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return (position == maxDistance);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
