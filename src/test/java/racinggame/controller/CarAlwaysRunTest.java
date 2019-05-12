package racinggame.controller;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarAlwaysRunTest {
    @Test
    void 항상_달리는_숫자가_동일한지_테스트() {
        /* Then */
        assertThat(new CarAlwaysRun().runOrStop()).isEqualTo(Car.MOVE_THRESHOLD);
    }
}