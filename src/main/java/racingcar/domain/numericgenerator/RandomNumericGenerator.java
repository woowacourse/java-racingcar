package racingcar.domain.numericgenerator;

import java.util.Random;

import racingcar.domain.NumericGenerator;

public class RandomNumericGenerator implements NumericGenerator {
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
