package racing.util;

public class RandomNumberGenerator {
    public static int generate(int limit) {
        return (int)(Math.random() * limit);
    }
}
