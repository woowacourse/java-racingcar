package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 전진() {
        Car car = new Car("pobi");
        car.move(4);
//        assertThat(car.getPosition()).isEqualTo(1);
    }
}
