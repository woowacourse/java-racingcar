package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int moveAndReturnPosition(MovementStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
        return position;
    }

    @Override
    public int compareTo(Car rhs) {
        return rhs.position - position;
    }

    public boolean isAtSamePositionWith(Car rhs) {
        return position == rhs.position;
    }

    @Override
    public String toString() {
        return name;
    }
}