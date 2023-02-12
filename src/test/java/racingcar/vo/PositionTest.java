package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Position;

class PositionTest {

    Position position = new Position(0);

    @Test
    @DisplayName("position 이동 성공 테스트")
    void positionIncreaseSuccessTest() {
        position.increase();
        position.increase();
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("position 이동 실패 테스트")
    void positionIncreaseFailTest() {
        position.increase();
        assertThat(position.getPosition()).isNotEqualTo(3);
    }

}