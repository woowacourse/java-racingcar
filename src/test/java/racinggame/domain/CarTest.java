package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new Car("이상"))
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차가 전진할 수 있다.")
    @Test
    void move() {
        Car car = new Car("아톰");

        car.move(() -> true);

        assertThat(car.isSamePositionWith(new Position(1))).isTrue();
    }

    @DisplayName("전진 조건을 만족하지 않으면 전진하지 않는다.")
    @Test
    void noMove() {
        Car car = new Car("아톰");

        car.move(() -> false);

        assertThat(car.isSamePositionWith(new Position(0))).isTrue();
    }
}
