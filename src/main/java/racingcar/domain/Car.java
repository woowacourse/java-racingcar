package racingcar.domain;

import static racingcar.constants.GameConstants.CAN_GO_VALUE;
import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.constants.GameConstants.INITIAL_POSITION;
import static racingcar.util.ValidatorUtils.validateCarName;

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

    public void goOrNot(int number) {
        if (canGo(number)) {
            go();
        }
    }

    private void go() {
        position += NUMBER_ONE_FOR_INCREMENT;
    }

    private boolean canGo(int number) {
        return number >= CAN_GO_VALUE;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
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
}
