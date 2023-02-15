package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

class PositionTest {
    @Test
    @DisplayName("위치 값은 음수가 아니어야 한다.")
    void position_shouldBePositive() {
        // expected
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ILLEGAL_POSITION.getMessage());
    }

    @Test
    @DisplayName("forward 메서드를 호출하면 위치 값이 증가해야 한다.")
    void position_shouldIncreasePositionValue() {
        // given
        Position position = new Position(0);

        // when
        position.forward();
        position.forward();
        position.forward();

        // expected
        assertThat(position.getValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("같은 위치 값을 갖는 Position은 같은 Position이어야 한다.")
    void position_sameValueIsSamePosition() {
        // given
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        // expected
        assertThat(position1).isEqualTo(position2);
    }

}
