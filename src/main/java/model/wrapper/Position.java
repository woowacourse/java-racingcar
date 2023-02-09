package model.wrapper;

import utils.RacingNumberGenerator;

public class Position implements Comparable<Position> {

    private static final int MOVABLE_VALUE = 4;

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move(RacingNumberGenerator generator) {
        if (generator.generate() >= MOVABLE_VALUE) {
            position++;
        }
    }

    public boolean isSamePosition(Position otherPosition) {
        return this.position == otherPosition.position;
    }

    @Override
    public int compareTo(Position otherPosition) {
        return this.position - otherPosition.position;
    }
}
