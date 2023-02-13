package racingcar.domain;

import racingcar.validator.CarNameValidator;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MOVING_DISTANCE = 1;

    private final String name;
    private int position;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = START_POSITION;
    }

    public void move(Movement movement) {
        if (movement.isMovable()) {
            position += MOVING_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
