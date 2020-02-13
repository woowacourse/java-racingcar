package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class WinnersTest {
    @Test
    void 자동차들의_위치중_가장_큰_값을_반환() {
        Cars cars = new Cars("무늬,두강,코일,쿨라임", 1);
        Winners winners = new Winners(cars);
        assertThat(winners.findCarAtMaxLocation(cars)).isEqualTo(4);
    }

    @Test
    void 위치가_가장_큰_자동차들의_이름을_반환() {
        List<String> result = new ArrayList<>();
        result.add("쿨라임");

        Cars cars = new Cars("무늬,두강,코일,쿨라임", 1);
        Winners winners = new Winners(cars);
        assertThat(winners.findWinners(cars, 4)).isEqualTo(result);
    }
}
