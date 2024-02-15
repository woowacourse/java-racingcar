package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @DisplayName("랜덤값이 4이상이면 전진한다.")
    @Test
    void testMove() {
        RacingCar racingCar = new RacingCar("pobi", () -> 4);
        racingCar.race();

        Assertions.assertThat(racingCar.getMoveNumber()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 4보다 작으면 전진한다.")
    @Test
    void testNotMove() {
        RacingCar racingCar = new RacingCar("pobi", () -> 3);
        racingCar.race();

        Assertions.assertThat(racingCar.getMoveNumber()).isEqualTo(0);
    }
}
