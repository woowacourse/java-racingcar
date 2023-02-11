package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.exception.DuplicateCarNamesException;
import racingcar.exception.NotExistCarsException;
import racingcar.model.car.strategy.ForwardMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("참여하는 자동차가 없는 경우 예외 처리가 되는지 테스트")
    @Test
    void validateNotExistCarsTest() {
        String carNames = ",,,";

        assertThatThrownBy(() -> {
            new Cars(carNames, new ForwardMovingStrategy());
        }).isInstanceOf(NotExistCarsException.class);
    }

    @DisplayName("중복된 이름이 존재할 경우 예외 처리가 되는지 테스트")
    @Test
    void validateDuplicateCarsNameTest() {
        assertThatThrownBy(() -> {
            new Cars("pobi,pobi", new ForwardMovingStrategy());
        }).isInstanceOf(DuplicateCarNamesException.class);
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        Cars cars = TestDataManager.getCarsTestData();
        int expected = 3;

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        int actual = cars.getCarsCurrentInfo()
                .get(0)
                .getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
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
