package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void 시도횟수로_경주를_생성한다() {
        Racing racing = new Racing(3);
        assertThat(racing.getClass()).isEqualTo(Racing.class);
    }

    @Test
    void 시도횟수가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Racing(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
