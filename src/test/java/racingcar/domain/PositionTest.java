package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void create() {
        Position position = new Position(1);
        Assertions.assertThat(position).isEqualTo(new Position(1));
    }
}
