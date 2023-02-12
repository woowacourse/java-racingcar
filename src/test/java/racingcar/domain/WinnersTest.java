package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.UserNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("가장 많이 전진한 차가 우승한다.")
    void calculateWinnersTest() {
        NumberGenerator numberGenerator = new UserNumberGenerator();

        Cars cars = new Cars("aa, bb");
        cars.moveCars(numberGenerator);
        cars.getCars().add(new Car("cc"));

        Winners winners = new Winners(cars);

        assertThat(winners.toString())
                .contains("aa")
                .contains("bb")
                .doesNotContain("cc");

    }
}