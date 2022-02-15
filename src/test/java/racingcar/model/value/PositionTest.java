package racingcar.model.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("위치 값을 증가시킨다")
    void moveTest() {
        // given
        Position position = new Position();

        // when
        position.move(1);

        // then
        assertThat(position.toInt()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치를 비교한다")
    void isSameTest() {
        // given
        Position position = new Position();

        // when
        position.move(2);

        // then
        assertThat(position.isSameWith(2)).isTrue();
    }
}
