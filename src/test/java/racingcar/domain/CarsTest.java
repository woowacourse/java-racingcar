package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름이 중복되었을 경우")
    void carsDuplicateNames() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "pobi");
        assertThatThrownBy(() -> {
            Cars cars = new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들 중 최대 position")
    void carsGetMaxPosition() {
        List<String> carNames = Arrays.asList("pobi", "amaz");
        Cars cars = new Cars(carNames);
        assertThat(cars.getMaxPositionByCars()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값을 전부 5로 통제한뒤, 전부 움직였는지 테스트")
    void carsMoveTestAlwaysMove() {
        List<String> carNames = Arrays.asList("povi", "pobi", "dave");
        Cars cars = new Cars(carNames) {
            @Override
            protected int getMovePivot() {
                return 5;
            }
        };
        cars.moveCars();

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("랜덤값을 전부 2로 통제한뒤, 전부 움직이지 못했는지 테스트")
    void carsMoveTestNoMove() {
        List<String> carNames = Arrays.asList("povi", "pobi", "dave");
        Cars cars = new Cars(carNames) {
            @Override
            protected int getMovePivot() {
                return 2;
            }
        };
        cars.moveCars();

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
