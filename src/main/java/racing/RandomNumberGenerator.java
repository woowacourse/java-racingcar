package racing;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int BOUND = 10;

    @Override
    public int generate() {
        return (int) (Math.random() * BOUND);
    }
}
