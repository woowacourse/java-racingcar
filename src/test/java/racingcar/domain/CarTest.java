package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    @ParameterizedTest
    @MethodSource("getTooLongName")
    @DisplayName("6자 이상의 이름으로 객체생성을 시도할 때")
    void tooLongCarNameTest(String tooLongName) {
        assertThatThrownBy(() -> new Car(tooLongName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    private static Stream<Arguments> getTooLongName() {
        return Stream.of(
            Arguments.of("123456"),
            Arguments.of("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk")
        );
    }

    @Test
    @DisplayName("빈 문자열(\"\")을 자동차 이름으로 할 때")
    void emptyCarNameTest() {
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 반드시 1자 이상 존재해야 합니다.");
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("null 을 자동차 이름으로 할 때")
    void nullCarNameTest(String name) {
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 반드시 1자 이상 존재해야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("getMoveValues")
    void move(int moveValue, int afterPosition) {
        Car car = new Car("히히");
        car.move(new MovingStrategyForTest(moveValue));
        assertThat(car.getPosition()).isEqualTo(afterPosition);
    }

    private static Stream<Arguments> getMoveValues() {
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 0),
            Arguments.of(3, 0),
            Arguments.of(4, 1),
            Arguments.of(6, 1),
            Arguments.of(9, 1)
        );
    }

    class MovingStrategyForTest implements MovingStrategy {
        private static final int MOVE_THRESHOLD = 4;

        private int value;

        public MovingStrategyForTest(int value) {
            this.value = value;
        }

        @Override
        public boolean movable() {
            return value >= MOVE_THRESHOLD;
        }
    }
}
