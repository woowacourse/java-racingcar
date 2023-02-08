package domain;

import util.RandomGenerator;

public class RacingCar extends RandomGenerator {

    private static final int moveThreshold = 4;

    private final Name name;
    private int position;

    RacingCar(final Name name) {
        this.name = name;
        position = 0;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return getRandomInteger() >= 4;
    }

    @Override
    protected int getRandomInteger() {
        return (int) (Math.random() * 10);
    }

    public int getPosition() {
        return position;
    }
}
