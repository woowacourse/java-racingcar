package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarCommander;

public class RandomGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("랜덤값을 생성한다.")
    void generateRandomNumber() {
        RacingCarCommander generator = new RacingCarCommander();
        int randomNumber = generator.generateRandomNumber();
        assertThat(randomNumber).isLessThan(10).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값을 생성하고 그 값에 따라 전진, 멈춤 여부를 받는다.")
    void getMovable() {
        RacingCarCommander generator = new RacingCarCommander();
        assertThat(generator.isMovable()).isInstanceOf(Boolean.class);
    }
}
