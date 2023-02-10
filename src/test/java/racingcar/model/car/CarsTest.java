package racingcar.model.car;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        Cars cars = TestDataManager.getCarsTestData();
        List<Integer> expectedPosition = List.of(3, 1, 3);

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        List<Car> movedCars = cars.getCars();

        // then
        assertThat(movedCars)
                .extracting("position")
                .isEqualTo(expectedPosition);
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
        List<Car> winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars)
                .extracting("carName")
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
        List<Car> winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars)
                .extracting("carName")
                .contains("pobi", "eddy");
    }

}
