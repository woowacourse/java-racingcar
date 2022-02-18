package racingcar.model;

import static racingcar.utils.validator.CarNamesValidator.validateCarName;

public class Car implements Comparable<Car> {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_FORWARD_CONDITION = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = validateCarName(name);
        this.position = INITIAL_POSITION;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(Car car) {
        return this.position == car.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CONDITION) {
            position++;
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.position);
    }
}
