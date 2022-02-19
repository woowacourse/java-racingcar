package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int INIT_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void proceed() {
        this.position++;
    }

    public boolean isHere(int position) {
        return this.position == position;
    }

    public CarDto toDto() {
        return new CarDto(this.getName(), this.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
