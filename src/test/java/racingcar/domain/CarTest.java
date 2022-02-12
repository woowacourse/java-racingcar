package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.MockRandomGenerator;

public class CarTest extends MockRandomGenerator {

    @Test
    void 자동차_전진_성공() {
        Car car = new Car("jae");
        randomNumberOverFour();
        car.goForward();
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void 자동차_전진_실패() {
        Car car = new Car("jae");
        randomNumberBelowFour();
        car.goForward();
        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    void 자동차_포지션_출력_성공() {
        Car car = new Car("jae");
        randomNumberOverFour();
        car.goForward();
        assertThat(car.toString()).isEqualTo("jae : -");

    }

    @AfterEach
    void stopMockRandom() {
        closeMockRandom();
    }
}
