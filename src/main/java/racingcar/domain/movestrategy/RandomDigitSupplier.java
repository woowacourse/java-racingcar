package racingcar.domain.movestrategy;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomDigitSupplier implements IntSupplier {

    private static final Random RANDOM = new Random();
    private static final int UPPER_BOUND_NUMBER = 10;

    @Override
    public int getAsInt() {
        return RANDOM.nextInt(UPPER_BOUND_NUMBER);
    }
}
