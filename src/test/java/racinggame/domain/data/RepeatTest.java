package racinggame.domain.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatTest {
    private static final String TEST_REPEAT = "1";

    @ParameterizedTest
    @ValueSource(strings = {"ABC", "2147483649"})
    void 횟수_입력시_타입_검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Repeat repeat = new Repeat(value);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("횟수는 정수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "0"})
    void 횟수_음수_입력시_예외검증(String value) {
        Assertions.assertThatThrownBy(() -> {
            Repeat repeat = new Repeat(value);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("횟수는 1이상의 정수만 가능합니다.");
    }
}
