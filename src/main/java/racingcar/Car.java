package racingcar;

public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 1;

    private int position = INIT_POSITION;
    private String name;

    protected Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptToMove(int number) {
        if (number >= 4) {
            position++;
        }
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
