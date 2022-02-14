package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerator.MovableNumberGenerator;
import racingcar.utils.numbergenerator.NumberGenerator;
import racingcar.utils.numbergenerator.StoppableNumberGenerator;

public class CarTest {

    private final NumberGenerator movableNumberGenerator = new MovableNumberGenerator();
    private final NumberGenerator stoppableNumberGenerator = new StoppableNumberGenerator();

    @Test
    void Car_생성_성공() {
        Car car = new Car("12345");
        assertThat(car.getName()).isEqualTo("12345");
    }

    @Test
    void 자동차_전진_성공() {
        Car car = new Car("jae");
        car.goForward(movableNumberGenerator);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void 자동차_전진_실패() {
        Car car = new Car("jae");
        car.goForward(stoppableNumberGenerator);
        assertThat(car.getPosition()).isEqualTo(0);

    }
}
