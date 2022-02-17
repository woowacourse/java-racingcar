package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarDtoTest {
    private final CarDto carDto = new CarDto("abc", 2);

    @Test
    @DisplayName("이름을 반환한다.")
    void getCarName_Test() {
        final String actual = carDto.getCarName();
        final String expected = "abc";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void getDistance_Test() {
        final int actual = carDto.getDistance();
        final int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }
}
