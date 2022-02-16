package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("포지션 기본 생성시 초기값은 0이어야 한다.")
    @Test
    void create() {
        Position position = new Position();
        assertThat(position.getPosition()).isZero();
    }

    @DisplayName("자동차 위치 값이 음수면 예외 발생")
    @Test
    void Should_ThrowException_When_PositionIsNegative() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차의 위치는 0이상의 양수 값을 가져야 합니다.");
    }
}
