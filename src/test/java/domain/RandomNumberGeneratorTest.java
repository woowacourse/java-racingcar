package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Test
    public void generateRandomNumberTest() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generate();
        Assertions.assertTrue(number >= 0 && number <= 10);
    }
}
