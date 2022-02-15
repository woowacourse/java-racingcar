package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 1;
    private static final int LOWER_MOVABLE_BOUND = 4;

    private final String name;
    private int position = INIT_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= LOWER_MOVABLE_BOUND;
    }

    public boolean isSamePositionWith(Car competitor) {
        return this.position == competitor.position;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
