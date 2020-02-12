package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import racingcar.domian.RacingCar;

public class RacingCarTest {
    RacingCar game;

    @BeforeAll
    void setUp() {
        game = new RacingCar();
    }
}
