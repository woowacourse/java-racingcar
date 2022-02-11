package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car = new Car("abc");

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void getCarName() {
        String actual = car.getCarName();
        String expected = "abc";
        assertThat(actual).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("boolean 타입 변수를 받아, true면 전진하고 false면 멈추고 자동차의 거리를 반환한다.")
    @CsvSource({"true, 1", "false, 0"})
    void getCarDistance_move(boolean movement, int expected) {
        car.move(movement);
        int actual = car.getDistance();
        assertThat(actual).isEqualTo(expected);
    }
}
