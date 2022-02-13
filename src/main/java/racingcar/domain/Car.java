package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int INIT_POSITION = 1;
    private static final int LOWER_MOVABLE_BOUND = 4;

    private int position = INIT_POSITION;
    private String name;

    Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptToMove(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= LOWER_MOVABLE_BOUND;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }

    public boolean isSamePositionWith(Car competitor) {
        return this.position == competitor.position;
    }

    public String getName() {
        return name;
    }
}
