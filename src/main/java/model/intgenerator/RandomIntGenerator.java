package model.intgenerator;

import java.util.Random;

public class RandomIntGenerator implements IntGenerator {
    @Override
    public int pickNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber + 1);
    }
}
