package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        Cars cars = Cars.from(List.of("pobi", "crong"), new ForwardMovingStrategy());
        String expected = "pobi : ---\ncrong : ---";

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }

        // then
        String actual = cars.getCarsPositionFormat();

        assertThat(actual).isEqualTo(expected);
    }
}