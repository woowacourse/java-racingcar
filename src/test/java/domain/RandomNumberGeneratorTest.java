package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("범위 난수 생성 테스트")
class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @DisplayName("생성된 난수는 지정된 범위를 벗어나지 않는다")
    @RepeatedTest(50)
    void testRangeOfRandomNumber() {
        Integer randomNumber = randomNumberGenerator.generate();
        assertThat(randomNumber).isBetween(0, 9);
    }
}