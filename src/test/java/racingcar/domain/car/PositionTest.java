package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.movement.FixedMovementStrategy;
import racingcar.domain.movement.MovementStrategy;

public class PositionTest {

    @Test
    void create() {
        Position position = new Position();
        assertThat(position.isSame(0)).isTrue();
    }

    @Test
    @DisplayName("포지션은 전진전략으로 이동할 수 있다.")
    public void testPositionMovement() {
        // given
        Position position = new Position();
        MovementStrategy strategy = new FixedMovementStrategy();
        // when
        position.move(strategy);
        // then
        assertThat(position.isSame(1)).isTrue();
    }

}
