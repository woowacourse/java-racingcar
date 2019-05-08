package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    void 랜덤난수() {
        for (int i = 0; i < 100; i++) {
            assertThat(racing.generateRandomNumber()).isBetween(0, 9);
        }
    }
}