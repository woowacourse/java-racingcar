package racing.util;

public class RandomNumberGenerator {
    public static int generate(final int limit) {
        return (int) (Math.random() * limit);
    }
}
