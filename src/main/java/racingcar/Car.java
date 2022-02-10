package racingcar;

public class Car implements Comparable<Car> {
    private int position = 0;


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
}
