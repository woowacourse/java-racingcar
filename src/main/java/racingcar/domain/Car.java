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

    public Car moveOrStop(MovementStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
        return this;
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

    public String drawTrail() {
        StringBuffer trail = new StringBuffer();

        for (int i = 0; i < position; i++) {
            trail.append("-");
        }
        return trail.toString();
    }
}