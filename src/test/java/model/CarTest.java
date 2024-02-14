package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름으로_자동차를_생성한다() {
        Car car = new Car("pobi");
        assertThat(car.getClass()).isEqualTo(Car.class);
    }

    @Test
    void 자동차_이름이_공백을_포함한_5자_초과면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("pobibi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어진_값이_4_이상인_경우_전진한다() {
        Car car = new Car("pobi");
        car.tryForward(() -> 4);
        assertThat(car.captureCarState().forwardCount()).isEqualTo(1);
    }

    @Test
    void 주어진_값이_4_미만인_경우_전진하지_않는다() {
        Car car = new Car("pobi");
        car.tryForward(() -> 3);
        assertThat(car.captureCarState().forwardCount()).isEqualTo(0);

    }
}
