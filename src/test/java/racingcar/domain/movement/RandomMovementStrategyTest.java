package racingcar.domain.movement;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomMovementStrategyTest {

    @Test
    public void move_RandomMovementIsZeroOrOne() {
        // given
        int random = new RandomMovementStrategy().move();
        // when
        Assertions.assertThat(random).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
        // then
    }
}