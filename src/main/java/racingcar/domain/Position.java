package racingcar.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public boolean isSame(Position position) {
        return this.position == getCurrentPosition(position);
    }

    public int comparePosition(Position position) {
        return Integer.compare(this.position, getCurrentPosition(position));
    }

    public int getCurrentPosition(Position position) {
        return position.position;
    }
}
