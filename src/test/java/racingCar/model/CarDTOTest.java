package racingCar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingCar.controller.service.RacingCarsService;
import racingCar.model.exception.name.NameRangeException;

class CarDTOTest {

    @Test
    void 이름확인() {
        assertThat(new CarDTO(new Car("hunch")).name)
                .isEqualTo("hunch");
    }

    @Test
    void position_확인() {
        assertThat(new CarDTO(new Car("hunch")).position)
                .isEqualTo(0);
    }

}