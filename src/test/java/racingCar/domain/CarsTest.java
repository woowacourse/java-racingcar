package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.util.FixedNumberGenerator;
import racingCar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void beforeEach() {
        cars = new Cars(List.of("a", "b", "c"));
    }

    @Test
    @DisplayName("자동차들 이름에 중복이 존재하면 예외가 발생한다.")
    void carsTest_duplicate_fail() {
        List<String> carNames = List.of("abc", "abc");

        Assertions.assertThatThrownBy(()->{
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차들 이름이 아무것도 없으면 예외가 터진다")
    void carsTest_empty_fail() {
        List<String> carNames = new ArrayList<>();

        Assertions.assertThatThrownBy(()->{
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들의 position 중 가장 높은 position 값을 가져온다")
    void findMaxPositionTest() {
        int maxPosition = cars.findMaxPosition();

        assertThat(maxPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차들의 거리가 모두 같으면 모두가 우승자가 된다.")
    void findWinnersTest() {
        List<String> winners = cars.findWinners();

        assertThat(winners).isEqualTo(List.of("a", "b", "c"));
    }
}
