package racinggame.domain;

import java.util.HashMap;
import java.util.Objects;

public class Car {
    private static final int ONE_STEP = 1;
    private static final int MOVING_THRESHOLD = 4;
    private static final int DEFAULT_POSITION = 0;
    private static final int NAME_LENGTH_BOUND = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        isNull(name);

        name = name.trim();
        validCarName(name);
        validCarPosition(position);

        this.name = name;
        this.position = position;
    }

    private void isNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null값은 입력할 수 없습니다.");
        }
    }

    private void validCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다");
        }
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름 길이 제한은 5자 이하입니다");
        }
    }

    private void validCarPosition(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException("postion은 0보다 커야 합니다.");
        }
    }

    public boolean move(int number) {
        if (number >= MOVING_THRESHOLD) {
            position += ONE_STEP;
            return true;
        }
        return false;
    }

    public HashMap<String, Integer> makeCarHistory() {
        HashMap<String, Integer> carHistory = new HashMap<>();

        carHistory.put(name, position);
        return carHistory;
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
