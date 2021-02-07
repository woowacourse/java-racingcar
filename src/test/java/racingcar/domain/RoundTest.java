package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    @Test
    public void 시도할_횟수는_숫자여야한다() {
        assertThatThrownBy(() -> {
            Round.of("a");
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest(name = "시도할_횟수는_1이상의_숫자여야_한다")
    @ValueSource(strings = {"0", "-1", "-5"})
    public void roundCountShouldBeBiggerThanOneTest(String values) {
        assertThatThrownBy(() -> {
            Round.of(values);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void roundCountShouldBeInIntRange() {
        assertThatThrownBy(() -> {
            String str = "100000000000000000000";
            Round.of(str);
        }).isInstanceOf(NumberFormatException.class);
    }
}
