package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingCar.domain.dto.CarDto;

@SuppressWarnings("NonAsciiCharacters")
public class CarDtoTest {
    @Test
    void 이름확인() {
        assertThat(new CarDto(new Car("hunch", 0)).getName())
                .isEqualTo("hunch");
    }

    @Test
    void position_확인() {
        assertThat(new CarDto(new Car("hunch", 5)).getPosition())
                .isEqualTo(5);
    }
}