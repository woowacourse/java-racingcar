package racingcar.model;

import java.util.Objects;

public class Car {

    public static final String CAR_NAME_INVALID = "자동차 이름이 유효하지 않습니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int MOVE_RANDOM_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateCarName(name.trim());
        this.name = name;
        this.position = position;
    }

    public void movePosition(int number) {
        if (number >= MOVE_RANDOM_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMaxPosition(int max) {
        return max == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() <= 0) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }
}
