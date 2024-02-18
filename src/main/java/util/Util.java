package util;
import java.util.Random;

public class Util {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static int generateRandomNumber() {
        int range = MAX_NUMBER - MIN_NUMBER + 1;

        Random random = new Random();
        return random.nextInt(range) + MIN_NUMBER;
    }
}
