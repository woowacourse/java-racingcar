package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void equals() {
        //given
        int positionDigit = 4;
        Position position = new Position(positionDigit);
        Position same = new Position(positionDigit);

        //then
        assertThat(position.equals(same)).isTrue();
    }
}