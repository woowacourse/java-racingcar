package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Disabled("많은 반복, 따로 테스트")
    @Test
    @DisplayName("generateNumber()시 범위내의 임이의 수를 생성한다.")
    @RepeatedTest(1000)
    void test_1() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int randomNumber = randomNumberGenerator.generateNumber(0, 9);

        // then
        Assertions.assertThat(randomNumber).isLessThanOrEqualTo(9);
        Assertions.assertThat(randomNumber).isGreaterThanOrEqualTo(0);
    }}
