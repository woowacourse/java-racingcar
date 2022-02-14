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
    @CsvSource({"0, 0, true", "0, 1, true", "1, 1, false"})
    @DisplayName("다른 자동차를 받아 자기 자신의 거리의 값이 크거나 같으면 true를 반환한다.")
    void isFartherThan(int firstMove, int secondMove, boolean expected){
        final Car anotherCar = new Car("def");
        anotherCar.move(firstMove);
        anotherCar.move(secondMove);
        assertThat(car.isFartherThan(anotherCar)).isEqualTo(expected);
    }
}
