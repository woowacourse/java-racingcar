package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

    @Test
    @DisplayName("자동차 우승자 이름을 계산한다.")
    void calculateWinnerNames() {
        RacingCars racingCars = new RacingCars("pobi,crong,honux");
        List<String> winnerNames = racingCars.searchWinnerNames();
        assertThat(winnerNames).containsExactly("pobi", "crong", "honux");
    }
}