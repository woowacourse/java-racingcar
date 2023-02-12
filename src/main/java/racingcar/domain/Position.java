package racingcar.domain;

public class Position implements Comparable<Position> {

    private int position;

    public Position() {
        this.position = 0;
    }

    public void moveOrStop(final int number) {
        if (number >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(final Position position) {
        return this.position - position.position;
    }
}

