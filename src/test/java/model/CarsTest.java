package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차_이름_리스트로_자동차_리스트를_생성한다() {
        Cars cars = Cars.fromNames(List.of("pobi", "dora"));
        assertThat(cars.getClass()).isEqualTo(Cars.class);
    }

    @Test
    void 중복된_자동차_이름이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Cars.fromNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차가_한_대_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> Cars.fromNames(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어진_값이_4_이상인_차들만_전진한다() {
        Car car1 = new Car("pobi", () -> 1);
        Car car2 = new Car("dora", () -> 3);
        Car car3 = new Car("ella", () -> 4);
        Car car4 = new Car("lupy", () -> 5);
        Car car5 = new Car("jojo", () -> 7);
        Cars cars = new Cars(List.of(car1, car2, car3, car4, car5));

        cars.tryForward();

        assertThat(cars.captureCarStates().get(0).forwardCount()).isEqualTo(0);
        assertThat(cars.captureCarStates().get(1).forwardCount()).isEqualTo(0);
        assertThat(cars.captureCarStates().get(2).forwardCount()).isEqualTo(1);
        assertThat(cars.captureCarStates().get(3).forwardCount()).isEqualTo(1);
        assertThat(cars.captureCarStates().get(4).forwardCount()).isEqualTo(1);
    }
}
