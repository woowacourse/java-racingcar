package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    void 자동차_이동_테스트() {
        assertThat(racing.isMove(1)).isEqualTo(false);
        assertThat(racing.isMove(2)).isEqualTo(false);
        assertThat(racing.isMove(3)).isEqualTo(false);
        assertThat(racing.isMove(4)).isEqualTo(true);
        assertThat(racing.isMove(5)).isEqualTo(true);
    }
}