package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.RandomNumberGenerator;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("생성된 난수는 0 이상 10 미만이다.")
    void randomBoundTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomNumber = randomNumberGenerator.generate();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("입력한 크기만큼의 난수를 생성한다.")
    void randomListSizeTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int size = 5;
        assertThat(randomNumberGenerator.generate(size)).hasSize(size);
    }
}
