package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.mock.MockMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

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
        final Car car = new Car("car", new MockMovingStrategy(List.of(true, false)));

        // when
        car.move();
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_위치를_비교한다() {
        // given
        final Car car1 = new Car("car1", new MockMovingStrategy(List.of(true)));
        final Car car2 = new Car("car2", new MockMovingStrategy(List.of(false)));

        // when
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