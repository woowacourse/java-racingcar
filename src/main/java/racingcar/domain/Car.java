package racingcar.domain;

import racingcar.validator.CarValidator;
import racingcar.validator.DefaultCarValidator;

import java.util.Objects;

public class Car {

    private final String name;
    private final CarMovement carMovement;
    private int position;

    public Car(String name) {
        this(name, new CarMovement(new RandomNumberGenerator()));
    }

    public Car(String name, CarMovement carMovement) {
        this.name = name;
        this.position = 0;
        this.carMovement = carMovement;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (carMovement.isCarMoveForward()) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
