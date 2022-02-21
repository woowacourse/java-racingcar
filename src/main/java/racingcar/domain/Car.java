package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.Objects;

public class Car {

    private static final int CONDITION_FOR_MOVE = 4;
    private static final int DEFAULT_POSITION = 0;

    private final CarName name;
    private int position;

    public Car(String name) {
        this(new CarName(name), DEFAULT_POSITION);
    }

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(NumberGenerator numberGenerator) {
        int target = numberGenerator.generate();

        if (target >= CONDITION_FOR_MOVE) {
            position++;
        }
    }

    public boolean isSamePosition(int target) {
        return position == target;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        Car car = (Car) o;
        return (this.getName()).equals(car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
