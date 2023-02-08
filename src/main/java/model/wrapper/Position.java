package model.wrapper;

import utils.RacingNumberGenerator;

public class Position {

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
}
