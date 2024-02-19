package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final String CAR_NAME_LENGTH_EXCEEDED = "자동차 이름 길이가 초과되었습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEEDED);
        }
    }

    public void move() {
        this.position++;
    }

    public boolean isSame(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return other.position - this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car other = (Car) o;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
