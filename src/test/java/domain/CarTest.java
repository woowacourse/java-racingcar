package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vo.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void givenName_whenMakingCar_thenReturnsCar() {
        String expected = "test";

        Car car = Car.of(expected);

        String result = car.getName();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Car 이름이 5글자 넘으면 예외발생")
    void givenNameHavingInvalidLength_whenMakingCar_thenThrowsException() {
        assertThatThrownBy(() -> Car.of("testTest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Car.INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest(name = "move() 메소드를 호출하여, 주어진 power 값({0})에 따라 position의 전진 여부 테스트")
    @CsvSource(value = {"4,1", "3,0"})
    void givenCar_whenMovingCar_thenAddsPosition(int power, long expected) {
        Car car = Car.of("test");

        car.move(power);

        assertThat(car.getPosition())
                .as("power 값이 4 이상이면 전진하고, 3 이하면 전진하지 않는다.")
                .isEqualTo(Position.of(expected));
    }
}