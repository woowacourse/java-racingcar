package racingcar;

import validator.CarNameValidator;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MOVING_DISTANCE = 1;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position += MOVING_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
