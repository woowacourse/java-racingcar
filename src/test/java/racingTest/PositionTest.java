package racingTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    @DisplayName("포지션 인스턴스 equals 비교 확인")
    void checkSamePositionByIntegerValue() {
        Position position1 = new Position(5);
        Position position2 = new Position(5);
        assertThat(position1).isEqualTo(position2);
    }

    @Test
    @DisplayName("포지션 1스텝 증가 확인")
    void checkPositionIncreaseByStepTest() {
        Position position = new Position(0);
        position.add();

        assertThat(position.getPosition()).isEqualTo(1);
    }
}
