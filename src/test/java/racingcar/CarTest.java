package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_전진_확인() {
        Car car = new Car("qwer");
        for (int i = 0; i <= 9; i++) {
            car.move(i);
        }
        assertThat(car.getPosition()).isEqualTo(6);
    }
}
