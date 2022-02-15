package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final Car car = new Car("abc");

    @BeforeEach
    void setUp() {
        car.move(1);
    }

    @ParameterizedTest
    @DisplayName("true를 받으면 전진하고 false를 받으면 정지한다.")
    @CsvSource({"1, 2", "0, 1"})
    void move(int movementValue, int expectedDistance) {
        car.move(movementValue);
        final CarDto actual = car.convertToDto();
        final CarDto expected = new CarDto("abc", expectedDistance);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 이름과 거리를 dto 변환해 반환한다.")
    void info() {
        final CarDto actual = car.convertToDto();
        final CarDto expected = new CarDto("abc", 1);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, -1", "1, 0", "2, 1"})
    @DisplayName("다른 자동차를 받아 자기 자신의 거리 값이 크면 -1, 작으면 1, 같으면 0을 반환한다.")
    void isFartherThan(int anotherCarMovement, int expected){
        final Car anotherCar = new Car("def");
        anotherCar.move(anotherCarMovement);
        int actual = car.compareTo(anotherCar);
        assertThat(actual).isEqualTo(expected);
    }
}
