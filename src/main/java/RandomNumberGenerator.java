import java.util.Random;

public class RandomNumberGenerator {
    static final int upperBound = 10;
    static Random random = new Random();

    public static int randomNumberGenerate() {
        return random.nextInt(upperBound);
    }
}
