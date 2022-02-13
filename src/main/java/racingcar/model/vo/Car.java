package racingcar.model.vo;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int ADVANCE_STANDARD = 4;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        String trimmedName = trim(name);
        validateBlank(trimmedName);
        validateLength(trimmedName);

        this.name = trimmedName;
    }

    private static String trim(String name) {
        return name.trim();
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private static void validateLength(final String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d글자가 넘을 수 없습니다.", MAXIMUM_LENGTH));
        }
    }

    public void advance(final int number) {
        if (number >= ADVANCE_STANDARD) {
            this.position++;
        }
    }

    public boolean isEqualPosition(final int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(final Car car) {
        return this.position - car.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return position == car.position && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}
