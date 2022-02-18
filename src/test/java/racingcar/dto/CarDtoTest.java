package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarDtoTest {
    private final CarDto carDto = new CarDto("abc", 2);

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void carName() {
        String actual = carDto.carName();
        String expected = "abc";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 이동거리를 반환한다.")
    void distance() {
        int actual = carDto.distance();
        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차를 DTO로 변환하여 반환한다.")
    void toDto() {
        Car car = new Car("abc");
        CarDto actual = CarDto.toDto(car);
        assertThat(actual.carName()).isEqualTo("abc");
        assertThat(actual.distance()).isEqualTo(0);
    }
}
