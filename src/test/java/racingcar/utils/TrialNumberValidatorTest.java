package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialNumberValidatorTest {
    @Test
    void 시도횟수_빈문자열() {
        assertThatThrownBy(() -> TrialNumberValidator.isEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_0인_경우() {
        assertThatThrownBy(() -> TrialNumberValidator.isNotPositive(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_음수인_경우() {
        assertThatThrownBy(() -> TrialNumberValidator.isNotPositive(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_문자입력1() {
        assertThatThrownBy(() -> TrialNumberValidator.isNotInteger("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_문자입력2() {
        assertThatThrownBy(() -> TrialNumberValidator.isNotInteger("*"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정수가_아닌_숫자_입력() {
        assertThatThrownBy(() -> TrialNumberValidator.isNotInteger("1.3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
