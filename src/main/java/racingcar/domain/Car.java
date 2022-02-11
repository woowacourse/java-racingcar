package racingcar.domain;

import java.util.Objects;

import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;

public class Car implements Comparable<Car> {

    private String name;
    private int position;
    private MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car maxCar) {
        return position == maxCar.position;
    }

    public int compareTo(Car s) {
        return position - s.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
