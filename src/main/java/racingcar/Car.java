package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    static final int NAME_LENGTH_LIMIT = 5;
    static final String NAME_IS_EMPTY
            = "자동차의 이름이 비어 있습니다.";
    static final String NAME_TOO_LONG
            = "자동차의 이름은 5자 이하여야 합니다.";
    static final String WRONG_POSITION
            = "잘못된 위치값입니다.";

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, final int position)
            throws IllegalArgumentException {
        name = name.strip();
        if (name.length() < 1) {
            throw new IllegalArgumentException(NAME_IS_EMPTY);
        }
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_TOO_LONG);
        }
        if (position < 0) {
            throw new IllegalArgumentException(WRONG_POSITION);
        }

        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward(CarList carList) {
        this.position++;
        carList.updateMaxPosition(this.position);

    }

    public void randomForward(boolean shouldGo, CarList carList) {
        if (shouldGo) {
            this.moveForward(carList);
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return this.position == car.position &&
                this.name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
