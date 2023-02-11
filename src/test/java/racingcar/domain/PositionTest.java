package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("값이 같으면 참이 반환되야 한다.")
    void position_sameValueEquals() {
        // given
        Position position1 = new Position(0);
        Position position2 = new Position(1);

        // when
        position1.forward();

        // then
        assertThat(position1)
                .isEqualTo(position2);
    }
    
    @Test
    @DisplayName("값이 다르면 거짓이 반환되어야 한다.")
    void position_differentValueNotEquals() {
        // given
        Position position1 = new Position(0);
        Position position2 = new Position(1);

        // expect
        assertThat(position1)
                .isNotEqualTo(position2);
    }
}
