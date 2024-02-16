package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MIN_NUMBER = 4;
    private static final int START_POSITION = 0;
    private final CarName name;
    private int position;

    private Car(final CarName name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(new CarName(name), START_POSITION);
    }

    public void go(final int number) {
        if (number >= MIN_NUMBER) {
            position++;
        }
    }

    public Car copy() {
        return new Car(name, position);
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
