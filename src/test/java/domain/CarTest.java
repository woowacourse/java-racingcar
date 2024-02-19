package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @DisplayName("차는 움직임을 시도한 후 원래 자리에 멈춰있거나 한 칸 움직인다.")
    @Test
    void testTryMoveThen() {
        Car car = Car.from("car");
        car.tryMove();
        assertThat(car.getPosition()).isIn(List.of(0, 1));
    }

    @DisplayName("차는 충분한 파워가 있는 경우 움직일 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testMoveWithSufficientPower(int power) {
        Car car = Car.of("car", 0, new MovablePowerGenerator());
        car.tryMove();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차는 충분한 파워가 없는 경우 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testMoveWithInsufficientPower(int power) {
        Car car = Car.of("car", 0, new NonMovablePowerGenerator());
        car.tryMove();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    static class MovablePowerGenerator implements PowerGenerator {
        @Override
        public Power generate() {
            return Power.from(4);
        }
    }

    static class NonMovablePowerGenerator implements PowerGenerator {
        @Override
        public Power generate() {
            return Power.from(3);
        }
    }
}
