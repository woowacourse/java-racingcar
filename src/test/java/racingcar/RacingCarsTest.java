package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름을 받아 자동차를 생성한다.")
    void createRacingCars() {
        RacingCars racingCars = new RacingCars("pobi,crong,honux");
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 이름의 공백을 제거한다.")
    void trimBlank() {
        RacingCars racingCars = new RacingCars("pobi , cr ong , honux");
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }
}