package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomMoveStrategyTest {
    @Test
    void canMove_NUM_FROM보다작은경우() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> RandomMoveCondition.canMove(RandomMoveCondition.NUM_FROM - 1));
    }

    @Test
    void canMove_NUM_TO보다큰경우() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> RandomMoveCondition.canMove(RandomMoveCondition.NUM_TO + 1));
    }

    @Test
    void canMove_NUM_MOVE_FROM() {
        assertThat(RandomMoveCondition.canMove(RandomMoveCondition.NUM_MOVE_FROM)).isTrue();
    }

    @Test
    void canMove_움직이지않을경우() {
        assertThat(RandomMoveCondition.canMove(RandomMoveCondition.NUM_MOVE_FROM -  1)).isFalse();
    }

}