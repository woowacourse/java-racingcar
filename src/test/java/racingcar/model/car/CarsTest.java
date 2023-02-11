package racingcar.model.car;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {
    @DisplayName("중복되는 자동차 이름은 존재할 수 없다.")
    @Test
    void carNameDuplicationTest() {
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        List<Car> cars = List.of(
                new Car("pobi", movingStrategy),
                new Car("pobi", movingStrategy)
        );

        assertThatCode(() -> {
            new Cars(cars);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.message());
    }

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
