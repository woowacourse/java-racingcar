package model.wrapper;

import utils.RacingNumberGenerator;

public class Position implements Comparable<Position> {

    private static final int MOVABLE_VALUE = 4;

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move(RacingNumberGenerator generator) {
        if (isMovable(generator)) {
            position++;
        }
    }

    private boolean isMovable(RacingNumberGenerator generator) {
        return generator.generate() >= MOVABLE_VALUE;
    }

    public boolean isSamePosition(Position otherPosition) {
        return this.position == otherPosition.position;
    }

    @Override
    public int compareTo(Position otherPosition) {
        return this.position - otherPosition.position;
    }
}
