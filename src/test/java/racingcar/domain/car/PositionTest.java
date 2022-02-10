package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void create() {
        Position position = new Position();
        assertThat(position.isSame(0)).isTrue();
    }
}
