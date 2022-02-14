package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    void 횟수_입력값이_1미만인_경우() {
        final int incorrectCount = 0;

        assertThatThrownBy(() -> new Count(incorrectCount))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("1 이상");
    }

    @Test
    void 횟수_입력값이_50초과인_경우() {
        final int incorrectCount = 51;

        assertThatThrownBy(() -> new Count(incorrectCount))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("50 이하");
    }
}
