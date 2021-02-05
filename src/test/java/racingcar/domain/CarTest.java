package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    public void 값이_4_이상이면_전진() {
        //given
        Car car = new Car(new Name("anne"));

        //when-then
        assertThat(car.movePosition(4)).isEqualTo(1);
    }

    @Test
    public void 값이_3_이하이면_멈춤() {
        //given
        Car car = new Car(new Name("anne"));

        //when-then
        assertThat(car.movePosition(3)).isEqualTo(0);
    }
}
