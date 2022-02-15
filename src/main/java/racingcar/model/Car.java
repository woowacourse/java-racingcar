package racingcar.model;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomUtil;

public class Car {
    private static final int STANDARD = 4;

    private final String name;
    private int position;


    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMovable(final RandomUtil randomNumberGenerator) {
        if (randomNumberGenerator.generate() >= STANDARD) {
            return true;
        }
        return false;
    }

    public void move(final RandomUtil randomNumberGenerator) {
        if (isMovable(randomNumberGenerator)) {
            position++;
        }
    }

    public boolean isMaxPosition(final int maxPosition) {
        return position == maxPosition;
    }
}
