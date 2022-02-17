package racingcargame.model.car;

public class Position implements Comparable<Position> {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void move(final int moveValue) {
        position += moveValue;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(final Position winnerPosition) {
        return this.position - winnerPosition.position;
    }
}
