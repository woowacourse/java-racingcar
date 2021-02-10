package racingcar.domain;

import static racingcar.domain.Position.ZERO;

public class Car {
    private static final String MARKER_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MARKER_OF_POSITION = "-";
    private static final int MOVING_BASELINE = 4;
    private static final int INITIAL_POSITION = 0;

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

    public void move(int number) {
        if (number >= MOVING_BASELINE) {
            position.move();
        }
    }

    public String getCurrentPosition() {
        StringBuilder current = new StringBuilder(name.getName());
        current.append(MARKER_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < position; i++) {
            current.append(MARKER_OF_POSITION);
        }
        return current.toString();
    }

    public boolean hasSamePositionWith(Car positionCar) {
        return this.position == positionCar.position;
    }

    public int compareTo(Car car) {
        return this.position - car.position;
    }
}