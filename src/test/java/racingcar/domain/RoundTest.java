package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    @Test
    void 시도할_회수로_입력된_값이_빈_문자열인_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> {
            Round.validateIsNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_회수가_숫자가_아닌_경우_예외_처리() {
        String input = "a";
        assertThatThrownBy(() -> {
            Round.validateIsNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_회수가_양수가_아닌_경우_예외_처리() {
        int input = -1;
        assertThatThrownBy(() -> {
            Round.validateIsPositiveNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
