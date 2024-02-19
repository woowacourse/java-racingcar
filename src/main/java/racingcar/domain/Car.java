package racingcar.domain;

import racingcar.domain.gamestatus.CarStatus;

public class Car {
    private static final int MAX_LENGTH = 5;

    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        validateCarNameLength(name);
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarStatus getStatus() {
        return new CarStatus(name, position);
    }
}
