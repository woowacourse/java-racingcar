package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Assertions.assertThat(new Car("pobi")).isNotNull();
    }

    @DisplayName("같은 위치 테스트")
    @Test
    void samePosition() {
        Assertions.assertThat(
                new Car("pobi", 3).isSamePosition(new Position(3)))
                .isTrue();
    }

    @DisplayName("다른 위치 테스트")
    @Test
    void differentPosition() {
        Assertions.assertThat(
                new Car("pobi", 4).isSamePosition(new Position(3)))
                .isFalse();
    }

    @DisplayName("전진 테스트")
    @Test
    void goForward() {
        final Car car = new Car("pobi");

        car.goForwardRandomly(() -> true);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop() {
        final Car car = new Car("pobi");

        car.goForwardRandomly(() -> false);

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}