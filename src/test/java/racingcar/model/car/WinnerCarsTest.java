package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;

class WinnerCarsTest {
    @DisplayName("우승한 자동차 생성 테스트")
    @Test
    void generateWinnerCarsFromCars() {
        //given
        Cars cars = TestDataManager.getCarsTestData();
        cars.moveCars();

        //when
        WinnerCars winnerCars = WinnerCars.fromCars(cars);

        //then
        assertThat(winnerCars.getCars()).hasSize(2)
                .extracting("position")
                .containsExactly(2, 2);
    }

}
