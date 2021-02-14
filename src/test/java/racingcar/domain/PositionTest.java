package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("0이나 자연수로 생성 - 성공")
    void valueOf_success() {
        assertThat(Position.valueOf(1).toInt()).isEqualTo(1);
        assertThat(Position.valueOf(1)).isEqualTo(Position.valueOf(1));
    }

    @Test
    @DisplayName("음수로 생성 - 실패")
    void valueOf_fail() {
        assertThatThrownBy(() -> Position.valueOf(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("value가 1이 오른 새로운 객체 반환")
    void plusOne() {
        Position position = Position.valueOf(1);

        assertThat(position.plusOne()).isEqualTo(Position.valueOf(2));
    }
}