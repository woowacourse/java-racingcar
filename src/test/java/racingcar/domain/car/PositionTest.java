package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("생성 테스트")
    @Test
    public void create() {
        Position position = new Position(3);
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @DisplayName("이동 테스트")
    @Test
    public void move() {
        Position position = Position.ZERO.move().move();
        assertThat(position.getPosition()).isEqualTo(2);
    }

}