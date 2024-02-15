package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int MIN_NUMBER = 4;
    private final CarName name;
    private int position;

    private Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(new CarName(name), 0);
    }

    public void go(final int number) {
        if (number >= MIN_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
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
