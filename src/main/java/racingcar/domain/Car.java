package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_VALUE_TO_MOVE = 4;
    private final String name;
    private int position = 0;

    private Car(String name) {
        validateCarNameIsNullOrEmpty(name);
        String trimmedName = name.trim();
        validateCarNameLength(trimmedName);
        this.name = trimmedName;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarState getCarState() {
        return CarState.of(name, position);
    }

    public void tryToMove(int randomValue) {
        if (randomValue >= MIN_VALUE_TO_MOVE) {
            position++;
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 1글자 이상 5글자 이하만 가능다.");
        }
    }

    private void validateCarNameIsNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 null 이거나 빈 문자열일 수 없습니다.");
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
