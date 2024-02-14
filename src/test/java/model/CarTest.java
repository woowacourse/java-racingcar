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
}
