package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("포지션 기본 생성시 초기값은 0이어야 한다.")
    @Test
    void create() {
        Position position = new Position();
        assertThat(position.isSame(0)).isTrue();
    }
}
