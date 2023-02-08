package utils;

public class RacingRandomNumberGenerator implements RacingNumberGenerator{

    private static final int MAX_VALUE = 9;

    @Override
    public int generate() {
        return (int) (Math.random() * MAX_VALUE);
    }
}
