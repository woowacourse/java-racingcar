package racingcar.model;

import racingcar.exception.InvalidCarNameException;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int INIT_POSITION = 1;
    private static final int LOWER_MOVABLE_BOUND = 4;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position = INIT_POSITION;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new InvalidCarNameException("자동차의 이름 길이는 " + MAXIMUM_CAR_NAME_LENGTH + "이하여야 합니다");
        }
        if (name.isEmpty()) {
            throw new InvalidCarNameException("자동차 이름을 입력해주세요");
        }
    }

    private boolean isMovable(int number) {
        return number >= LOWER_MOVABLE_BOUND;
    }

    public boolean isSamePositionWith(Car competitor) {
        return this.position == competitor.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
