package racingcar.domain;

import static racingcar.domain.Position.ZERO;

public class Car {
    private static final int MOVING_BASELINE = 4;

    private Name name;
    private Position position;

    public Car(final String name, final int position) {
        this(new Name(name), new Position(position));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(final Name name) {
        this(name, ZERO);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(int number) {
        if (number >= MOVING_BASELINE) {
            this.position = position.move();
        }
    }

    public boolean isSamePosition(int position) {
        return this.position.isSamePosition(position);
    }

    public int getMaxPosition(int position) {
        return this.position.getMaxPosition(position);
    }
}