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

    @Test
    @DisplayName("랜덤값을 생성하고 그 값에 따라 전진, 멈춤 여부를 받는다.")
    void getMovable() {
        RandomGenerator generator = new RandomGenerator();
        assertThat(generator.isMovable()).isInstanceOf(Boolean.class);
    }
}
