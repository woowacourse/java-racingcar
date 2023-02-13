package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @Test
    @DisplayName("값이 같으면 참이 반환되야 한다.")
    void position_sameValueEquals() {
        // given
        Position position1 = new Position(0);
        Position position2 = new Position(1);

        // when
        position1.forward();

        // then
        assertThat(position1)
                .isEqualTo(position2);
    }

    @Test
    @DisplayName("값이 다르면 거짓이 반환되어야 한다.")
    void position_differentValueNotEquals() {
        // given
        Position position1 = new Position(0);
        Position position2 = new Position(1);

        // expect
        assertThat(position1)
                .isNotEqualTo(position2);
    }

    @Test
    @DisplayName("foward 호출 시 위치가 증가되어야 한다.")
    void forward_shouldBeIncrease() {
        // given
        Position position = new Position(0);

        // when
        position.forward();

        // then
        assertThat(position.getValue())
                .isGreaterThan(0);
    }

    @Test
    @DisplayName("위치에 음수가 주어지면 예외가 발생해야 한다.")
    void create_minusInput() {
        // expect
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_POSITION.getMessage());
    }

    @ParameterizedTest
    @DisplayName("위치가 정상적으로 생성되어야 한다.")
    @ValueSource(ints = {0, 1, 2, Integer.MAX_VALUE})
    void create_success(int input) {
        // expect
        assertThatCode(() -> new Position(input))
                .doesNotThrowAnyException();
    }
}
