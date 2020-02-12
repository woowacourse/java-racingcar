package racingcargame.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNumberExceptionTest {

    @Test
    void 이동값_범위_초과() {
        int input = -1;
        assertThatThrownBy(() -> TryNumberException.checkExceedRange(input))
                .isInstanceOf(RuntimeException.class);
    }
}
