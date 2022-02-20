package racingcar.domain.car;

import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.Objects;

public class Car {
    private static final int MOVE_CRITERIA = 4;

    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        position = 0;
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }

    public void move(NumberGenerator numberGenerator) {
        int number = numberGenerator.generateNumber();

        if (number >= MOVE_CRITERIA) {
            position++;
        }
    }


    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
