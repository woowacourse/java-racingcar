package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionTest {

    @Test
    void INIT_메서드로_초기화() {
        Position position = Position.init();
        assertThat(position.getMoveCount()).isZero();
    }

    @Test
    void NEXT_메서드로_증가된_Status_값객체_생성() {
        Position position = Position.init();
        Position movedPosition = position.next();
        assertThat(movedPosition.getMoveCount()).isEqualTo(1);
        assertThat(movedPosition).isNotEqualTo(position);
    }
}
