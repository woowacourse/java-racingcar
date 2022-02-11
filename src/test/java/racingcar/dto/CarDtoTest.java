package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarDtoTest {
    private final CarDto carDto = new CarDto("abc", 2);

    @Test
    @DisplayName("이름을 반환한다.")
    void carName() {
        String actual = carDto.carName();
        String expected = "abc";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void distance() {
        int actual = carDto.distance();
        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }
}