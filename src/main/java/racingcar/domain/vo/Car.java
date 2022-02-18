package racingcar.domain.vo;

import static racingcar.domain.util.MovementUtil.isMoveForward;

public class Car implements Comparable<Car> {

    private static final String TO_STRING_DELIMITER = ":";
    private static final int SAME_POSITION = 0;

    private CarName name;
    private Position position;

    public Car(CarName carName) {
        this.name = carName;
        this.position = new Position();
    }

    public CarName getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.get() + TO_STRING_DELIMITER + position.toString();
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    public boolean isSameName(Car car) {
        return car.name.equals(this.name);
    }

    public boolean isSamePosition(Car car) {
        return position.compareTo(car.position) == SAME_POSITION;
    }

    public void move(int number) {
        if (isMoveForward(number)) {
            position.increase();
        }
    }
}
