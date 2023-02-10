package helper;

import utils.RacingNumberGenerator;

public class StubUnmovableRacingNumberGenerator implements RacingNumberGenerator {

    private static final int UNMOVABLE_VALUE = 3;

    @Override
    public int generate() {
        return UNMOVABLE_VALUE;
    }
}
