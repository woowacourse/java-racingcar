package car.domain;

import static car.option.Option.INITIAL_POSITION;
import static car.option.Option.MAX_NAME_LENGTH;
import static car.option.Option.MIN_NAME_LENGTH;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validateNameLength(name);
        validatePositionOverInitialPosition(position);
        this.name = name;
        this.position = position;
    }

    private void validatePositionOverInitialPosition(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치는 시작점보다 작으면 안됩니다.");
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

    public int selectMaxPosition(int otherPosition) {
        return Math.max(position, otherPosition);
    }

    public boolean hasSamePositionWith(int otherPosition) {
        return position == otherPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveChance moveChance) {
        if (moveChance.isMovable())
            position++;
    }
}
