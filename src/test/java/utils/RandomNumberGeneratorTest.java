package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    void randomNumberGenerateTest() {
        int generateNumber = RandomNumberGenerator.generate();
        assertTrue(generateNumber >= 0 && generateNumber <= 9);
    }
}