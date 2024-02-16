package support;

import util.NumberGenerator;

public class ImmovableNumberGenerator implements NumberGenerator {
    private static final int IMMUTABLE_NUMBER = 3;

    @Override
    public int generateNumber() {
        return IMMUTABLE_NUMBER;
    }
}
