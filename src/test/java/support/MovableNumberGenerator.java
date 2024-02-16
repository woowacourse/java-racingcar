package support;

import util.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public int generateNumber() {
        return MOVABLE_NUMBER;
    }
}
