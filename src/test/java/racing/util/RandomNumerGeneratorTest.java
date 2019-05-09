package racing.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumerGeneratorTest {
    @Test
    void 랜덤숫자생성테스트() {
        for (int i = 0; i < 1000000; i++)
            assertThat(RandomNumberGenerator.generate(10)).isBetween(0, 9);
    }
}
