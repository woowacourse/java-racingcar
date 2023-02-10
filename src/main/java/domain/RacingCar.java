package domain;

import util.RandomGenerator;

public class RacingCar extends RandomGenerator {

    private static final int MOVE_THRESHOLD = 4;

    private final Name name;
    private int position;

    public RacingCar(final String name) {
        this.name = new Name(name);
        position = 0;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return getRandomInteger() >= MOVE_THRESHOLD;
    }

    @Override
    protected int getRandomInteger() {
        return (int) (Math.random() * 10);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
