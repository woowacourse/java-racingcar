package domain;

import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class RandomMove implements IntSupplier {

    private static final Random RANDOM = new Random();

    @Override
    public int getAsInt() {
        return Math.abs(RANDOM.nextInt() % 10);
    }
}
