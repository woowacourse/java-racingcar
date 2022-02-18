package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarDtoTest {
    private final CarDto carDto = new CarDto("abc", 2);

    @Test
    @DisplayName("이름을 반환한다.")
    void getCarName_Test() {
        //given
        final String expected = "abc";
        //when
        final String actual = carDto.getCarName();
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void getDistance_Test() {
        //given
        final int expected = 2;
        //when
        final int actual = carDto.getDistance();
        //then
        assertThat(actual).isEqualTo(expected);
    }
}