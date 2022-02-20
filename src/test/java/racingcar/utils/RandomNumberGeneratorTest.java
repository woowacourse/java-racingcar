package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("랜덤값이 정해진 범위에서 생성되는지 테스트")
    void makeRandom() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int random = randomNumberGenerator.generateNumber();
        Assertions.assertThat(random).isLessThan(10).isGreaterThanOrEqualTo(0);
    }
}
