package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int getRandom() {
        return new Random().nextInt(10);
    }
}
