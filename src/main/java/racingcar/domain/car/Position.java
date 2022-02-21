package racingcar.domain.car;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public boolean isEqual(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }
}
