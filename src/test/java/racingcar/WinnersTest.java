package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.util.FixedNumberGenerator;
import racingcar.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void 우승자_확인() {
        Cars cars = Cars.initCars("bom,sun");
        NumberGenerator numberGenerator = new FixedNumberGenerator(4);
        cars.race(numberGenerator);
        Winners winners = new Winners(cars);

        assertThat(winners.makeWinnerName(",")).contains("bom").contains("sun");
    }
}
