package racingcar.model;

import java.util.Objects;

public class Car {

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

    public void go(final NumberGenerator generator) {
        if (generator.generate() >= MIN_NUMBER) {
            position++;
        }
    }

    public boolean isWin(Car river) {
        return position > river.position;
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

    public boolean isSamePosition(Car target) {
        return position == target.position;
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

    @Override
    public String toString() {
        return name.toString() + ": " + position;
    }
}
