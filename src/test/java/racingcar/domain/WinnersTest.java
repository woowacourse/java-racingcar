package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 자동차들의_위치중_가장_큰_값을_반환() {
        Cars cars = new Cars("무늬,두강,코일,쿨라임", 1);
        Winners winners = new Winners(cars);
        assertThat(winners.findCarAtMaxLocation(cars)).isEqualTo(4);
    }

    @Test
    void 위치가_가장_큰_자동차의_이름을_반환() {
        Cars cars = new Cars("무늬,두강,코일,쿨라임", 1);
        Winners winners = new Winners(cars);

        assertThat(winners.getWinnersName()).isEqualTo("쿨라임");
    }
}
