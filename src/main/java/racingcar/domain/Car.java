package racingcar.domain;

import racingcar.validator.CarNameValidator;

import java.util.Objects;

public class Car {
    private static final int PROCEED_FlAG_NUMBER = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = 0;
    }

    public void proceed(final int number) {
        if (number >= PROCEED_FlAG_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
