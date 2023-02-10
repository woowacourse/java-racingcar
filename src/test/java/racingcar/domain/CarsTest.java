package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private Cars cars;
    private List<String> carNames = List.of("pobi", "crong", "honux");

    @Nested
    @DisplayName("CarRepository 생성에 대한 테스트")
    class CarsInitializerTest {
        @Test
        @DisplayName("차 이름이 중복되는 경우 예외가 발생한다")
        void duplicatedNameTest() {
            List<String> duplicatedCarNames = List.of("pobi", "pobi");
            assertThatThrownBy(() -> cars = new Cars(duplicatedCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름이 중복됩니다.");
        }

        @Test
        @DisplayName("차 개수가 2대 미만인 경우 예외가 발생한다.")
        void carCountTest() {
            List<String> carNames = List.of("pobi");
            assertThatThrownBy(() -> new Cars(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 수는 2대 이상이어야 합니다.");
        }
    }

    @Nested
    @DisplayName("우승자들의 이름을 제대로 추출하는지 검증한다")
    class GetWinnersTest {
        @Test
        @DisplayName("모두의 위치가 같은 경우 모두가 우승자가 된다")
        void allCarsAreWinner() {
            cars = new Cars(carNames);
            assertThat(cars.getWinnerCarsName())
                    .isEqualTo(carNames);
        }
    }
}
