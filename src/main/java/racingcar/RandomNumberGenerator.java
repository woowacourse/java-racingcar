import java.util.Random;

public class RandomNumberGenerator {

    private static final int MAX_RANDOM_INT = 10;

    public static int generate() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_INT);
    }
}
