package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;
    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public static Car from(String name) {
        return new Car(name);
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_BOUNDARY_NUMBER) {
            position++;
        }
    }
}
