package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TryNumberTest {

    @Test
    void 범위초과숫자입력() {
        int input = -100;
        assertThatThrownBy(() ->
                new TryNumber(input))
                .isInstanceOf(RuntimeException.class);
    }

}