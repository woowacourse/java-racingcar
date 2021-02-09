package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("포지션 생성 테스트")
    @Test
    void createPosition() {
        Position position = new Position(1);

        Assertions.assertThat(new Position(1)).isEqualTo(position);
    }
}
