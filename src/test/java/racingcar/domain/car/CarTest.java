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

    @Test
    void 자동차_위치를_비교한다() {
        // given
        Car car1 = new Car("car1", new MockMovingStrategy(List.of(true, true)));
        Car car2 = new Car("car2", new MockMovingStrategy(List.of(true, false)));

        // when
        car1.move();
        car2.move();

        car1.move();
        car2.move();

        // then
        assertSoftly(softly -> {
            softly.assertThat(car1.compareTo(car1)).isEqualTo(0);
            softly.assertThat(car1.compareTo(car2)).isEqualTo(1);
            softly.assertThat(car2.compareTo(car1)).isEqualTo(-1);
        });
    }
}