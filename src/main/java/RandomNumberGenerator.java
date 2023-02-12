import java.util.Random;

public class RandomNumberGenerator {
    private static final int upperBound = 10;
    private static final Random random = new Random();

    public static int generateRandomPower() {
        return random.nextInt(upperBound);
    }
}
