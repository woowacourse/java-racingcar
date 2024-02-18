package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_FORWARD_LOWER_BOUND = 3;
    private static final Pattern FIND_SPECIAL_CHARACTER = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");

    private final String name;
    private int distance = 0;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 너무 깁니다.");
        }
        if (FIND_SPECIAL_CHARACTER.matcher(name).find()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에는 특수문자가 들어갈 수 없습니다.");
        }
    }

    public void moveForward(final int condition) {
        if (condition > MOVE_FORWARD_LOWER_BOUND) {
            distance++;
        }
    }

    public String getCarName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
