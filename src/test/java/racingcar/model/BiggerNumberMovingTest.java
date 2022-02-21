package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BiggerNumberMovingTest {

    @Test
    public void shouldMove() {
        Moving moving = new BiggerNumberMoving();
        boolean biggerThanFour = moving.canMove(5);
        assertThat(biggerThanFour).isTrue();
    }

    @Test
    public void shouldNotMove() {
        Moving moving = new BiggerNumberMoving();
        boolean lessThanFour = moving.canMove(3);
        assertThat(lessThanFour).isFalse();
    }

}