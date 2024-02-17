package racingcar.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.dto.CarStatus;

public class Car implements Comparable<Car> {
    private static final Pattern NAME_PATTERN = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9_-]");
    private static final int MAX_NAME_LENGTH = 5;
    private static final int CAR_MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(final String name) {
        validateNotNull(name);
        validateNameStyle(name);
        validateNameLength(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNameStyle(final String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);

        if (matcher.find()) {
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름의 길이가 %d를 초과합니다", MAX_NAME_LENGTH)
            );
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

    public CarStatus getCarStatus() {
        return new CarStatus(name, position);
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
