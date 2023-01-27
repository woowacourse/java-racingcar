package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름을_저장할_수_있다() {
        // given
        String carName = "Jinho";
        Car car = new RandomMovingCar(carName);

        // when
        String result = car.getName();

        // then
        assertThat(result).isEqualTo(carName);
    }
}
