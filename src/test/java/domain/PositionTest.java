package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("위치 테스트")
class PositionTest {

    @DisplayName("move를 호출하면 위치가 1만큼 변경된다")
    @Test
    void testMove() {
        Position position = new Position(0);
        position.move();
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
