package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Nested
    @DisplayName("move 메소드는")
    class Move {
        @Test
        @DisplayName("1칸 이동할 수 있다.")
        void it_increase_position() {
            Car car = new Car(new Name("car1"));
            car.move(() -> true);
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("isInPosition 메소드는")
    class IsInPosition {
        @Nested
        @DisplayName("해당 위치에 있다면")
        class Context_with_correct_position {
            @Test
            @DisplayName("true를 반환한다.")
            void it_returns_true() {
                Car car = new Car(new Name("car1"));
                assertThat(car.isInPosition(new Position(0))).isTrue();
            }
        }

        @Nested
        @DisplayName("해당 위치에 없다면")
        class Context_with_incorrect_position {
            @Test
            @DisplayName("false를 반환한다.")
            void it_returns_false() {
                Car car = new Car(new Name("car1"));
                assertThat(car.isInPosition(new Position(1))).isFalse();
            }
        }
    }
}
