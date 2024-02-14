package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.intgenerator.IntGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    IntGenerator intGenerator;
    @BeforeEach
    void setUp() {
        intGenerator = () -> 1;
    }

    @Test
    void 자동차_이름으로_자동차를_생성한다() {
        Car car = new Car("pobi", intGenerator);
        assertThat(car.getClass()).isEqualTo(Car.class);
    }

    @Test
    void 자동차_이름이_공백을_포함한_5자_초과면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("pobibi", intGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어진_값이_4_이상인_경우_전진한다() {
        Car car = new Car("pobi", () -> 4);
        car.tryForward();
        assertThat(car.captureCarState().forwardCount()).isEqualTo(1);
    }

    @Test
    void 주어진_값이_4_미만인_경우_전진하지_않는다() {
        Car car = new Car("pobi", () -> 3);
        car.tryForward();
        assertThat(car.captureCarState().forwardCount()).isEqualTo(0);
    }
}
