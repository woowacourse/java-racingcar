package racingcargame.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoTest {
    private final CarDto carDto = new CarDto("애니", 3);

    @DisplayName("이름 반환이 정상적으로 되는지 테스트")
    @Test
    void getName() {
        assertThat(carDto.getName()).isEqualTo("애니");
    }

    @DisplayName("자동차 위치값 반환이 정상적으로 되는지 테스트")
    @Test
    void getPosition() {
        assertThat(carDto.getPosition()).isEqualTo(3);
    }
}