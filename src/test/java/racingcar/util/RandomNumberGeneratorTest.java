package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {
    @Test
    public void 랜덤값_범위_확인() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int value = randomNumberGenerator.generate();
        assertTrue(0 <= value && value <= 9);
    }
}
