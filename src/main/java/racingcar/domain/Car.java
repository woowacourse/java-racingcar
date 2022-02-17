package racingcar.domain;

import java.util.Objects;

import static racingcar.util.ValidatorUtils.validateNotBlank;
import static racingcar.util.ValidatorUtils.validateNotOverFiveCharacters;

public class Car {

    private static final int CAN_GO_VALUE = 4;
    private static final int POSITION_INCREMENT_UNIT = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNotBlank(name);
        validateNotOverFiveCharacters(name);
        this.name = name;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void goOrNot(int number) {
        if (canGo(number)) {
            go();
        }
    }

    private void go() {
        position += POSITION_INCREMENT_UNIT;
    }

    private boolean canGo(int number) {
        return number >= CAN_GO_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean hasSamePosition(int value) {
        return position == value;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Car(this.name, this.position);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
