package racingcar.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car implements Comparable<Car> {
    private final int MAX_NAME_LENGTH = 5;
    private final int CAR_MOVE_THRESHOLD = 4;
    private final Pattern NAME_PATTERN = Pattern.compile("[^a-zA-Z0-9_-]");
    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateNameStyle(name);
        validateNameLength(name);
    }

    private void validateNameStyle(final String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);

        if (matcher.find()) {
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름의 길이가 %d를 초과합니다", MAX_NAME_LENGTH
            ));
        }
    }

    public void move(final int threshold) {
        if (threshold >= CAR_MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
