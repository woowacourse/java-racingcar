package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NonAsciiCharacters")
public class RandomNumberGeneratorTest {

    @DisplayName("랜덤값 범위 확인 테스트")
    @Test
    void generateTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int value = randomNumberGenerator.generate();
        assertTrue(0 <= value && value <= 9);
    }
}
