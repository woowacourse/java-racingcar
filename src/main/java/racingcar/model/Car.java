package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {
    private static final int STANDARD = 4;

    private final String name;
    private int position;


    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(final RandomUtil randomNumberGenerator) {
        if (isMovable(randomNumberGenerator)) {
            position++;
        }
    }

    public boolean isMovable(final RandomUtil randomNumberGenerator) {
        return randomNumberGenerator.generate() >= STANDARD;
    }

    public boolean isMaxPosition(final int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
