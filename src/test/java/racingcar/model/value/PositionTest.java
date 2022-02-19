package racingcar.model.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("위치 값을 증가시킨다")
    void moveTest() {
        // given
        Position position = Position.create();

        // when
        position.move(1);

        // then
        assertThat(position.toInt()).isEqualTo(1);
    }
}
