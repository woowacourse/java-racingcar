package car.domain;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        validatePosition(position);
        this.name = new Name(name);
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

    private void validatePosition(int position) {
        if (position < START_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치는 시작점보다 작으면 안됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Car car = (Car)o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
