package model.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private static final int MOVE_STATE = 1;
    private static final int STOP_STATE = 0;
    private static final int MOVABLE_VALUE = 4;
    private static final int UNMOVABLE_VALUE = 3;

    private Position position;

    @BeforeEach
    void beforeEach() {
        position = new Position();
    }

    @Test
    @DisplayName("4 이상의 값이 생성되면 한칸 전진한다.")
    void move() {
        position.move(MOVABLE_VALUE);

        Assertions.assertThat(position.getPosition()).isSameAs(MOVE_STATE);
    }

    @Test
    @DisplayName("3 이하의 값이 생성되면 멈춘다.")
    void stop() {
        position.move(UNMOVABLE_VALUE);

        Assertions.assertThat(position.getPosition()).isSameAs(STOP_STATE);
    }
}