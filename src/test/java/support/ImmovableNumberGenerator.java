package support;

import util.NumberGenerator;

public class ImmovableNumberGenerator implements NumberGenerator {
    private static final int IMMOVABLE_NUMBER = 3;

    @Override
    public int generateNumber() {
        return IMMOVABLE_NUMBER;
    }
}
