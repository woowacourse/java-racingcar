package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void 시도횟수로_경주를_생성한다() {
        Racing racing = new Racing(3);
        assertThat(racing.getClass()).isEqualTo(Racing.class);
    }

    @Test
    void 시도횟수가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Racing(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수만큼_전진을_시도한다() {
        Car car1 = new Car("pobi", () -> 1);
        Car car2 = new Car("dora", () -> 3);
        Car car3 = new Car("ella", () -> 4);
        Car car4 = new Car("lupy", () -> 5);
        Car car5 = new Car("jojo", () -> 7);
        Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));

        Racing racing = new Racing(3);
        racing.tryToForward(cars);

        assertThat(cars.captureCarStates().get(0).forwardCount()).isEqualTo(0);
        assertThat(cars.captureCarStates().get(1).forwardCount()).isEqualTo(0);
        assertThat(cars.captureCarStates().get(2).forwardCount()).isEqualTo(3);
        assertThat(cars.captureCarStates().get(3).forwardCount()).isEqualTo(3);
        assertThat(cars.captureCarStates().get(4).forwardCount()).isEqualTo(3);
    }
}
