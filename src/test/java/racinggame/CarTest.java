package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> Car.from("이상"))
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차가 전진할 수 있다.")
    @Test
    void move() {
        Car car = Car.from("아톰");

        car.move();

        assertThat(car.isSamePosition(Car.of("other", 1))).isTrue();
    }
}
