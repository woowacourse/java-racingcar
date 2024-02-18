package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        validateSize(name);
    }

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 길이가 초과되었습니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public boolean isSame(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.position - this.position;
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
        return Objects.equals(name, car.name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
