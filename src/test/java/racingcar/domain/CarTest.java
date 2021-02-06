package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void winner와_position이_같은지_확인() {
        Car car1 = new Car(new Name("anne"));
        Car car2 = new Car(new Name("jo"));
        car1.movePosition(5);
        car2.movePosition(5);
        assertEquals(true, car1.hasSamePositionWith(car2));
    }
}
