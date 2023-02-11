package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.exception.DuplicateCarNamesException;
import racingcar.exception.InvalidCarNameFormatException;
import racingcar.model.car.strategy.ForwardMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @DisplayName("중복된 이름이 존재할 경우 예외 처리가 되는지 테스트")
    @Test
    void validateDuplicateCarsNameTest() {
        Car pobi = new Car("pobi", new ForwardMovingStrategy());

        assertThatThrownBy(() -> {
            new Cars(List.of(pobi, pobi));
        }).isInstanceOf(DuplicateCarNamesException.class);
    }

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
        List<Car> winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.get(0).getCarName()).contains("pobi");
        assertThat(winnerCars.get(1).getCarName()).contains("eddy");
    }
}
