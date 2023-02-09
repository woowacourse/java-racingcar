package utils;

public class RacingRandomNumberGenerator implements RacingNumberGenerator{

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public int generate() {
        return (int) (Math.random() * (MAX_VALUE - MIN_VALUE + 1));
    }
}
