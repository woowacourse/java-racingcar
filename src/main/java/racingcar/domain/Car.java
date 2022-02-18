package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름이 null이거나 빈 문자열, 혹은 공백으로만 이루어져 있습니다.";
    private static final String POSITION_ERROR_MESSAGE = "자동차의 위치는 최소 0 이상이어야 합니다.";
    private final String name;
    private int position;

    public Car(String name) {
        carNameCheck(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    private Car(String name, int position) {
        carNameCheck(name);
        positionCheck(position);
        this.name = name;
        this.position = position;
    }

    public void proceed() {
        this.position++;
    }

    public boolean isHere(int position) {
        return this.position == position;
    }

    public Car deepCopy() {
        return new Car(this.getName(), this.getPosition());
    }

    private void positionCheck(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(POSITION_ERROR_MESSAGE);
        }
    }

    private void carNameCheck(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
