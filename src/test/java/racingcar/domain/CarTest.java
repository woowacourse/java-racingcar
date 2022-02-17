package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car = new Car("abc");

    @BeforeEach
    void setUp() {
        car.move(true);
    }

    @Test
    @DisplayName("자동차의 이름과 거리를 dto 변환해 반환한다.")
    void toDto() {
        CarDto actual = CarDto.toDto(car);
        CarDto expected = new CarDto("abc", 1);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"false, false, 1", "false, true, 0", "true, true, -1"})
    @DisplayName("다른 자동차의 거리값에 비해 자기 자신의 거리값이 작으면 -1, 같으면 0, 크면 1을 반환한다. ")
    void compareTo(boolean firstMove, boolean secondMove, int expected){
        Car anotherCar = new Car("def");
        anotherCar.move(firstMove);
        anotherCar.move(secondMove);
        assertThat(car.compareTo(anotherCar)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"false, false, false", "false, true, true", "true, true, false"})
    @DisplayName("자기 자신의 거리값과 다른 자동차의 거리값이 같으면 true, 다르면 false를 리턴한다.")
    void isSameDistance(boolean firstMove, boolean secondMove,  boolean expected){
        Car anotherCar = new Car("def");
        anotherCar.move(firstMove);
        anotherCar.move(secondMove);
        assertThat(car.isSameDistance(anotherCar.getDistance())).isEqualTo(expected);
    }
}
