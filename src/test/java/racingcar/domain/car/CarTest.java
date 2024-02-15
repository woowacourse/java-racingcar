package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockMovingStrategy;

class CarTest {
    @Test
    void 자동차_생성_성공() {
        // given
        String name = "car";

        // when
        Car car = new Car(name, new MockMovingStrategy());

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차_움직임_성공() {
        // given
        List<Boolean> movableList = List.of(true, false, true, false, true);
        Car car = new Car("car", new MockMovingStrategy(movableList));

        // when
        for (int i = 0; i < movableList.size(); i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }
}