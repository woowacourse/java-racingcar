package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest {
    private final RandomPowerGenerator randomPowerGenerator = new RandomPowerGenerator();

    @Test
    void randomPowerGenerateTest() {
        int randomPower = randomPowerGenerator.generate();
        assertTrue(randomPower >= 0 && randomPower <= 9);
    }
}