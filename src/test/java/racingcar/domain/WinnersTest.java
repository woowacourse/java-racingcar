package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.UserNumberGenerator;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("가장 많이 전진한 차가 우승한다.")
    void calculateWinnersTest() {
        NumberGenerator numberGenerator = new UserNumberGenerator();

        Cars cars = new Cars(new String[]{"aa", "bb"});
        cars.moveCars(numberGenerator);
        cars.getCars().add(new Car("cc"));

        OutputView outputView = new OutputView();
        Winners winners = new Winners(cars);

        assertThat(outputView.winnersToString(winners))
                .contains("aa")
                .contains("bb")
                .doesNotContain("cc");

    }
}