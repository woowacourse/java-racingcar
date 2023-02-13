package racing.domain.car;

import java.util.Objects;

public class Car {
    private static final int LEAST_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_START_POSITION = 0;
    private static final int ONE_STEP = 1;
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = DEFAULT_START_POSITION;
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 다섯 글자 이하여야합니다.");
        }
    }

    public void moveDependingOn(int pickedNumber) {
        if (pickedNumber >= LEAST_CONDITION) {
            position += ONE_STEP;
        }
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
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
