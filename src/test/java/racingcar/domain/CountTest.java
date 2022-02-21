package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    void 횟수가_1미만인_경우_예외발생() {
        final int incorrectCount = 0;

        assertThatThrownBy(() -> new Count(incorrectCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    void 횟수가_50초과인_경우_예외발생() {
        final int incorrectCount = 51;

        assertThatThrownBy(() -> new Count(incorrectCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("50 이하");
    }

    @Test
    void 횟수가_1인_경우() {
        final int correctCount = 1;

        assertThatCode(() -> new Count(correctCount)).doesNotThrowAnyException();
    }

    @Test
    void 횟수가_50인_경우() {
        final int correctCount = 50;

        assertThatCode(() -> new Count(correctCount)).doesNotThrowAnyException();
    }
}
