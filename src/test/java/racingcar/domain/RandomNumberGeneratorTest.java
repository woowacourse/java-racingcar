package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("RandomNumberGenerator 클래스")
class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("generate 메서드는 0 부터 9 사이의 숫자를 무작위로 생성한다.")
    void should_returnNumber_betweenZeroToNine_when_generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}
