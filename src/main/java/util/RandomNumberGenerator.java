package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
