package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차들 이름이 중복되었을 경우")
    void cars_중복된_자동차_이름() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "pobi");
        assertThatThrownBy(() -> {
            Cars cars = new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들 중 최대 position car 확인")
    void carsGetMaxPosition() {
        List<String> carNames = Arrays.asList("pobi", "amaz");
        Cars cars = new Cars(carNames);
        assertThat(cars.getMaxPositionCar())
                .isExactlyInstanceOf(Car.class);
    }
}
