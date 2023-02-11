package utils;

public class RacingRandomNumberGenerator implements RacingNumberGenerator{

    private static final int MIN_INCLUSIVE_VALUE = 0;
    private static final int MAX_INCLUSIVE_VALUE = 9;

    @Override
    public int generate() {
        return (int) (Math.random() * (MAX_INCLUSIVE_VALUE - MIN_INCLUSIVE_VALUE + 1));
    }
}
