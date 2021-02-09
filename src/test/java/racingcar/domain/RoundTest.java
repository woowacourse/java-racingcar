package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    @ParameterizedTest(name = "시도할_횟수는_1이상의_숫자여야_한다")
    @ValueSource(ints = {0, -1, -5})
    public void roundCountShouldBeBiggerThanOneTest(int count) {
        assertThatThrownBy(() -> {
            Round.of(count);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
