package domain;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomMoveStrategy implements IntSupplier {
    private static final int MAX_RANDOM_INT = 10;
    private static final Random random = new Random();

    @Override
    public int getAsInt() {
        return random.nextInt(MAX_RANDOM_INT);
    }
}
