package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_FORWARD_LOWER_BOUND = 3;
    private static final String EMPTY_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름은 비어있을 수 없습니다.";
    private static final String TOO_LONG_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름이 너무 깁니다.";
    private static final String SPECIAL_CHARACTER_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름에는 특수문자가 들어갈 수 없습니다.";

    private final String name;
    private int distance = 0;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_EXCEPTION);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME_EXCEPTION);
        }
        Pattern pattern = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");
        if (pattern.matcher(name).find()) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_CAR_NAME_EXCEPTION);
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
