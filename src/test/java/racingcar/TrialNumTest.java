package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.TrialNum;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialNumTest {
    @Test
    void 시도횟수가_숫자가_아닌경우_예외처리() {
        assertThatThrownBy(() -> {
            TrialNum.initTrialNum("-");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
