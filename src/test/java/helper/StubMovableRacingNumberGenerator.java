package helper;

import utils.RacingNumberGenerator;

public class StubMovableRacingNumberGenerator implements RacingNumberGenerator {

    private static final int MOVABLE_VALUE = 4;

    @Override
    public int generate() {
        return MOVABLE_VALUE;
    }
}
