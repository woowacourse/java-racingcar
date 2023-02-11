package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.model.car.strategy.ForwardMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        Car pobi = new Car("pobi", new ForwardMovingStrategy());
        Cars cars = new Cars(List.of(pobi));
        int expected = 3;

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }

        // then
        assertThat(cars.getCarsCurrentInfo().get(0).getPosition()).isEqualTo(expected);
    }

    @DisplayName("우승한 자동차 선별 테스트")
    @Test
    void winnerCarTest() {
        // given
        Cars cars = TestDataManager.getCarsTestData();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .doesNotContain("crong");

    }

    @DisplayName("공동 우승 출력 테스트")
    @Test
    void winnerCarFormatTest() {
        // given
        Cars cars = TestDataManager.getCarsTestData();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .contains("eddy");

    }

}