package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate(int minNumber, int maxNumber) {
        Random random = new Random();
        return random.nextInt(minNumber, maxNumber + 1);
    }
}