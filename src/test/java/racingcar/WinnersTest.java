package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.Winners;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void 우승자_차의_이름을_반환하는지_확인() {
        Cars cars = Cars.initCars("bom,sun");
        Winners winners = new Winners(cars);
        String expected = "bom, sun";

        assertThat(winners.makeWinnerName(", ")).isEqualTo(expected);
    }
}
