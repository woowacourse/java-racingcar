package domain;

import java.util.Random;

public class RandomThrottleGenerator implements ThrottleGenerator {

    private final int MAX_THROTTLE = 10;

    @Override
    public int generate() {
        return new Random().nextInt(MAX_THROTTLE);
    }
}
