package domain;

import java.util.Comparator;
import java.util.Objects;

public class Car {
    private static final int LEAST_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int START_POSITION = 0;
    private static final int ONE_STEP = 1;
    public static final Comparator<Car> positionComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.position - o2.position;
        }
    };

    private final String name;
    private int position;


    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
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

    public CarDto toDTO() {
        return new CarDto(name, position);
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
