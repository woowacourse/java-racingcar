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
    void info() {
        CarDto actual = car.info();
        CarDto expected = new CarDto("abc", 1);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"false, false, true", "false, true, true", "true, true, false"})
    @DisplayName("다른 자동차를 받아 자기 자신의 거리의 값이 크거나 같으면 true를 반환한다.")
    void isFartherThan(boolean firstMove, boolean secondMove, boolean expected){
        Car anotherCar = new Car("def");
        anotherCar.move(firstMove);
        anotherCar.move(secondMove);
        assertThat(car.isFartherThan(anotherCar)).isEqualTo(expected);
    }
}
