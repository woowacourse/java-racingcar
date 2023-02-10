package racing.domain;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int BOUND = 10;

    @Override
    public int generate() {
        return (int) (Math.random() * BOUND);
    }
}
