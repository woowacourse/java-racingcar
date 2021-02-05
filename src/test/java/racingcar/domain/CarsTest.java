package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarsTest {
    @DisplayName("자동차 이름이 중복되었을 경우")
    @Test
    void cars_중복된_자동차_이름() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "pobi");
        assertThatThrownBy(() -> {
            Cars.setCars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차들 중 최대 position")
    @Test
    void carsGetMaxPosition() {
        List<String> carNames = Arrays.asList("pobi", "amaz");
        Cars.setCars(carNames);
        assertThat(Cars.getMaxPositionByCars()).isEqualTo(0);
    }
}
