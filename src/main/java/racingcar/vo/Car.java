package racingcar.vo;

import static racingcar.util.MovementUtil.isMoveForward;

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

    public CarName getName() {
        return name;
    }
}
