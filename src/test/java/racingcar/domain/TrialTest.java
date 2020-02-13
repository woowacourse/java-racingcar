package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialTest {
    @Test
    void 시도_횟수가_숫자가_아닌_경우() {
        assertThatThrownBy(() -> new Trial("두번"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("시도 횟수는 숫자를 입력해주세요.");
    }

    @Test
    void 시도_횟수가_양수가_아닌_경우() {
        assertThatThrownBy(() -> new Trial("-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수만 입력해주세요.");
    }
}
