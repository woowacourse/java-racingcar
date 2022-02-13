package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StubNumberGenerator;

import static org.assertj.core.api.Assertions.*;

public class CarsTest{

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new StubNumberGenerator();
    }

    @Test
    void 자동차_우승_1명_성공() {
        Cars cars = new Cars(new String[]{"jae","rick"});
        cars.moveCars(numberGenerator);
        assertThat(cars.getWinners()).isEqualTo("rick가 최종 우승 했습니다.");
    }

    @Test
    void 자동차_우승_2명_성공() {
        Cars cars = new Cars(new String[]{"jae", "rick"});
        for (int i = 0; i < 2; i++) {
            cars.moveCars(numberGenerator);
        }
        assertThat(cars.getWinners()).isEqualTo("jae, rick가 최종 우승 했습니다.");
    }

}