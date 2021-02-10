package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVABLE_RPM_MIN = 4;
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    public void tryToMove(final int currentRPM) {
        if (currentRPM >= MOVABLE_RPM_MIN) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarName(final String name) {
        if (name.length() > NAME_LENGTH_MAX || name.length() < NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(
                "자동차 이름은 " + NAME_LENGTH_MIN + "자 이상 " + NAME_LENGTH_MAX + "자 이하로 입력해주세요.");
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
