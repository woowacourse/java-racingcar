package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.number.RandomNumberGenerator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("지정된 범위의 난수 생성")
    void randomNumberMake() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < 999999; i++) {
            int madeNumber = randomNumberGenerator.generate();
            assertThat(madeNumber).isBetween(0, 9);
        }
    }
}
