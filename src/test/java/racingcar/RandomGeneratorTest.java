package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomGeneratorTest {
    @RepeatedTest(10)
    @DisplayName("랜덤값을 생성한다.")
    void generateRandomNumber() {
        RandomGenerator generator = new RandomGenerator();
        int randomNumber = generator.generateRandomNumber();
        assertThat(randomNumber).isLessThan(10).isGreaterThanOrEqualTo(0);
    }
}
