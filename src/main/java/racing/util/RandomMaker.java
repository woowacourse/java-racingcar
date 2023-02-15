package racing.util;

import java.util.Random;

public class RandomMaker {
    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
