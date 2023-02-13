package racing.domain;

import racing.RandomNumberGenerator;

public class CarRandomNumberGenerator implements RandomNumberGenerator {

    private static final int BOUND = 10;

    @Override
    public int generate() {
        return (int) (Math.random() * BOUND);
    }
}
