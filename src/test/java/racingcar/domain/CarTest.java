package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final int FORWARD_STANDARD = 4;

    @Test
    void 자동차_전진_성공() {
        Car car = new Car("jae");
        car.goForward(FORWARD_STANDARD);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void 자동차_전진_실패() {
        Car car = new Car("jae");
        car.goForward(FORWARD_STANDARD - 1);
        assertThat(car.getPosition()).isEqualTo(0);

    }
}
