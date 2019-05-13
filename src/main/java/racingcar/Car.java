package racingcar;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkName(name);
        this.name = name.trim();
        this.position = position;
    }

    private void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("올바르지 않은 접근입니다.");
        }
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 1~5자만 가능합니다.");
        }
    }

    public void move(int number) {
        position += (number >= FORWARD_NUM) ? 1 : 0;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
