package domain;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int RANGE = 10;
    @Override
    public int generateNumber() {
        return (int) (Math.random() * RANGE);
    }
}
