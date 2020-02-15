package racingcargame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int STEP_SIZE = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isSame(int comparedPosition) {
        return position == comparedPosition;
    }

    public void move() {
        position += STEP_SIZE;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }

    public int getPosition() {
        return position;
    }
}
