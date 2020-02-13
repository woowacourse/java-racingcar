package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이름_부여() {
        Car car = new Car("pobi");
        assertThat(car.toString()).isEqualTo("pobi");
    }

    @Test
    void 전진하기() {
        Car car = new Car("pobi");
        assertThat(car.movePosition(4)).isEqualTo(1);
    }

    @Test
    void 멈추기() {
        Car car = new Car("pobi");
        assertThat(car.movePosition(3)).isEqualTo(0);
    }
}
