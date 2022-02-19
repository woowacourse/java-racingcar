package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @Test
    @DisplayName("자동차의 위치를 나타내는 객체 생성 기능 확인")
    public void create_valid_position() {
        assertThat(new Position().getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치값을 전진시키는 기능 확인")
    public void move_forward() {
        Position position = new Position();

        assertThat(position.moveForward().getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("자동차 위치값이 동일한지 수행하는 기능 확인")
    public void same_valid_position(int value) {
        Position position = new Position();

        assertThat(position.isSamePosition(value)).isTrue();
    }
}
