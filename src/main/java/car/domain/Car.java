package car.domain;

import static car.option.Option.MAX_NAME_LENGTH;
import static car.option.Option.MIN_NAME_LENGTH;
import static car.option.Option.START_POSITION;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        validateNameLength(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    public boolean isFartherThan(Car other) {
        return position > other.position;
    }

    public boolean hasSamePositionWith(Car other) {
        return position == other.position;
    }

    public void move(MoveChance moveChance) {
        if (moveChance.isMovable()) {
            position++;
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 너무 깁니다.");
        }
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 너무 짧습니다.");
        }
    }

    private void validatePosition(int position) {
        if (position < START_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치는 시작점보다 작으면 안됩니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
