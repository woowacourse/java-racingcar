package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.domian.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingCar game;

    @BeforeAll
    void setUp() {
        game = new RacingCar();
    }

    @RepeatedTest(10)
    void 생성된_랜덤값_범위_0부터9() {
        int random = game.generateRandom();
        assertThat(0 <= random && random < 10).isTrue();
    }
}
