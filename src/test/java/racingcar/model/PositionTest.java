package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    public void isZeroWhenStarted() {
        Position startPosition = Position.createStartPosition();
        assertThat(startPosition.getCurrentPosition()).isEqualTo(0);
    }

    @Test
    public void increase() {
        Position location = Position.createStartPosition();
        location.increase();
        assertThat(location.getCurrentPosition()).isEqualTo(1);
    }
}
