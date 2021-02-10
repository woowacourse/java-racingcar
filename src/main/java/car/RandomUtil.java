package car;

import java.util.Random;

public class RandomUtil {
    private static final int MAX_NUMBER = 9;
    
    private static final Random RANDOM = new Random();
    
    private RandomUtil() {}
    
    public static int getRandomValue() {
        return RANDOM.nextInt(MAX_NUMBER + 1);
    }
}
