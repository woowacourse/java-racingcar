package domain;

public class FixedNumberGenerator implements NumberGenerator {

    private static int MOVABLE_NUMBER = 4;

    @Override
    public int generate() {
        return MOVABLE_NUMBER;
    }
}
