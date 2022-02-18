package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialNumTest {
    @Test
    void 시도횟수가_숫자가_아닌경우_예외처리() {
        assertThatThrownBy(() -> {
            TrialNum.validateTrialInput("-");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
