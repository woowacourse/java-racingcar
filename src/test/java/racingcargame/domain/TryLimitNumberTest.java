package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryLimitNumberTest {
    @Test
    void 범위초과_마이너스_숫자입력() {
        int input = -1;
        assertThatThrownBy(() ->
                new TryLimitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위초과_제로_숫자입력() {
        int input = 0;
        assertThatThrownBy(() ->
                new TryLimitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}