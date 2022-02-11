package racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TrialTest {

    @Test
    @DisplayName("시도횟수가 1보다 작을 경우 예외를 발생한다")
    void trail_negative() {
        assertThatThrownBy(() -> Trial.create(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

}