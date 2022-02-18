package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    private static final String CAR_NAME = "pobi";

    @Test
    public void 자동차_전진() {
        Car car = new Car(CAR_NAME);
        car.forwardCarPosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
