package racingcargame.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoTest {
    private final CarDto carDto = new CarDto("애니", 3);

    @DisplayName("자동차 이름을 반환해준다.")
    @Test
    void getName() {
        assertThat(carDto.getName()).isEqualTo("애니");
    }

    @DisplayName("자동차 위치 값을 반환해준다.")
    @Test
    void getPosition() {
        assertThat(carDto.getPosition()).isEqualTo(3);
    }
}