package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.StubNumberGenerator;

import static org.assertj.core.api.Assertions.*;

public class CarsTest{

    @Test
    void 자동차_우승_2명_성공() {
        Cars cars = new Cars(new String[]{"jae","rick"});
        cars.moveCars(new StubNumberGenerator());
        assertThat(cars.getWinners()).isEqualTo("jae, rick가 최종 우승 했습니다.");
    }

}