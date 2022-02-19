package racingcar.domain;

import static racingcar.constants.GameConstants.INITIAL_POSITION;
import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.util.ValidatorUtils.validateCarName;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validateCarName(name);

        this.name = name;
        this.position = position;
    }

    public void goOrNot(MoveStrategy moveStrategy) {
        if (moveStrategy.canGo()) {
            go();
        }
    }

    private void go() {
        position += NUMBER_ONE_FOR_INCREMENT;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
