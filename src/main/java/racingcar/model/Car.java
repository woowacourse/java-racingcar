package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int START_POSITION = 0;

    private final CarName name;
    private int position;

    public Car(final CarName name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void go(final int number) {
        if (number >= MIN_MOVABLE_NUMBER) {
            position++;
        }
    }

    public boolean isSamePosition(final Car other) {
        return position == other.position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
