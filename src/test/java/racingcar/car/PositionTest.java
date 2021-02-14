package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Position;

public class PositionTest {

    @Test
    @DisplayName("위치가 잘 들어갔는지 확인")
    void positionTest() {
        Position position = Position.valueOf(3);
        assertThat(position).isEqualTo(Position.valueOf(3));
    }

    @Test
    @DisplayName("position 0이 같은 인스턴스인지 확인")
    void isInstanceTest() {
        Position position = Position.valueOf(0);
        assertThat(position).isSameAs(Position.valueOf(0));
    }
    
    @Test
    @DisplayName("위치 이동 기능이 잘 동작하는지 확인")
    void positionAddTest() {
        Position position = Position.valueOf(2);
        assertThat(position.addPosition(4)).isEqualTo(Position.valueOf(3));
        assertThat(position.addPosition(3)).isEqualTo(Position.valueOf(2));
    }

    @Test
    @DisplayName("값 비교시 true, false 반환 테스트")
    void equalTest() {
        Position position = Position.valueOf(3);
        assertThat(position.isEqualNumber(3)).isTrue();
        assertThat(position.isEqualNumber(4)).isFalse();
    }
}
