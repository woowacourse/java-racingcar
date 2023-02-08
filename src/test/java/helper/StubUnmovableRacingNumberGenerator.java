package helper;

import utils.RacingNumberGenerator;

public class StubUnmovableRacingNumberGenerator implements RacingNumberGenerator {

    @Override
    public int generate() {
        return 3;
    }
}
