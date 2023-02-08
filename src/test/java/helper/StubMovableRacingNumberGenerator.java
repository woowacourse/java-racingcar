package helper;

import utils.RacingNumberGenerator;

public class StubMovableRacingNumberGenerator implements RacingNumberGenerator {

    @Override
    public int generate() {
        return 4;
    }
}
