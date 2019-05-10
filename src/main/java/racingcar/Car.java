package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    static final int NAME_LENGTH_LIMIT;
    static final String NAME_IS_EMPTY;
    static final String NAME_TOO_LONG;

    static {
        NAME_LENGTH_LIMIT = 5;
        NAME_IS_EMPTY = "자동차의 이름이 비어 있습니다.";
        NAME_TOO_LONG = "자동차의 이름은 5자 이하여야 합니다.";
    }

    public Car(String name)
            throws IllegalArgumentException {
        name = name.strip();
        if (name.length() < 1) {
            throw new IllegalArgumentException(NAME_IS_EMPTY);
        }
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_TOO_LONG);
        }

        this.name = name;
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
