package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockMovingStrategy;

class CarTest {
    @Test
    void 자동차_생성_성공() {
        // given
        final String name = "car";

        // when
        final Car car = new Car(name, new MockMovingStrategy());

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차_움직임_성공() {
        // given
        final List<Boolean> movableList = List.of(true, false, true, false, true);
        final Car car = new Car("car", new MockMovingStrategy(movableList));

        // when
        for (int i = 0; i < movableList.size(); i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void 자동차_위치를_비교한다() {
        // given
        final Car frontCar = new Car("car1", new MockMovingStrategy(List.of(true)));
        final Car behindCar = new Car("car2", new MockMovingStrategy(List.of(false)));

        // when
        frontCar.move();
        behindCar.move();

        // then
        assertSoftly(softly -> {
            softly.assertThat(frontCar.compareTo(frontCar)).isEqualTo(0);
            softly.assertThat(frontCar.compareTo(behindCar)).isEqualTo(1);
            softly.assertThat(behindCar.compareTo(frontCar)).isEqualTo(-1);
        });
    }
}
