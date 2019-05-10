package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int position = 0;
    private final String name;

    public Car(final String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
