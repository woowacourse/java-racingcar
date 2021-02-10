package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("Position 생성 테스트")
    void positionCreate() {
        Position position = new Position();
        assertThat(position).isEqualTo(new Position());
    }

    @Test
    @DisplayName("최대 Position 반환 테스트")
    void positionGetMax() {
        Position position1 = new Position(3);
        Position position2 = new Position(4);
        assertThat(position1.getMaxPosition(position2)).isEqualTo(position2);
    }

}
