package racingcar.vo;

import static racingcar.util.MovementUtil.isMoveForward;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final String RESULT_DELIMITER = " : ";
    private static final int SAME_POSITION = 0;

    private final CarName name;
    private final Position position;

    public Car(String carName) {
        this.name = new CarName(carName);
        this.position = new Position();
    }

    public Car(CarName carName, Position position) {
        this.name = carName;
        this.position = position;
    }

    public boolean isSameName(Car car) {
        return car.name.equals(this.name);
    }

    public boolean isSamePosition(Car car) {
        return position.compareTo(car.position) == SAME_POSITION;
    }

    public Car move(int number) {
        if (isMoveForward((number))) {
            return new Car(name, position.increase());
        }
        return this;
    }

    @Override
    public String toString() {
        return name.getName() + RESULT_DELIMITER + position.toString();
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return name.equals(car.name) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public CarName getName() {
        return name;
    }
}
