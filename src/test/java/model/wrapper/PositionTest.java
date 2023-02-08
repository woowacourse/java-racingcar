package model.wrapper;

import helper.StubMovableRacingNumberGenerator;
import helper.StubUnmovableRacingNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Position position;

    @BeforeEach
    void beforeEach() {
        position = new Position();
    }

    @Test
    @DisplayName("4 이상의 값이 생성되면 한칸 전진한다.")
    void move() {
        position.move(new StubMovableRacingNumberGenerator());

        Assertions.assertThat(position.getPosition()).isSameAs(1);
    }

    @Test
    @DisplayName("3 이하의 값이 생성되면 멈춘다.")
    void stop() {
        position.move(new StubUnmovableRacingNumberGenerator());

        Assertions.assertThat(position.getPosition()).isSameAs(0);
    }
}