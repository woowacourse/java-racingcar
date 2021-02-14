package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("포지션 생성 테스트")
    @Test
    void createPosition() {
        Position position = new Position(1);

        Assertions.assertThat(new Position(1)).isEqualTo(position);
    }

    @DisplayName("위치 이동 테스트")
    @Test
    void movePosition() {
        Position position = new Position(0);

        Assertions.assertThat(position.goForward().getValue()).isEqualTo(1);
    }
}
