package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차의 초기 포지션이 0인지 검증한다")
    void carInitPositionTest() {
        Car car = new Car("aa");
        int position = car.getPosition();
        assertThat(position)
                .isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0", "4:1", "5:1", "9:1"}, delimiter = ':')
    @DisplayName("3이하 정지, 4이상 전진")
    void carMoveTest(int number, int position) {
        Car car = new Car("aa");

        car.move(number);
        int carPosition = car.getPosition();

        assertThat(carPosition)
                .isEqualTo(position);
    }
}
