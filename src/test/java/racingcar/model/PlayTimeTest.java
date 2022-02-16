package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PlayTimeTest {

    @Test
    public void biggerThanZero() {
        assertThatThrownBy(() -> new PlayTime(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}