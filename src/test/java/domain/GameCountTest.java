package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameCountTest {

    @ParameterizedTest(name = "횟수가 1 미만이거나 10억 초과면 예외 발생")
    @ValueSource(strings = {"", "applej", "0", "1000000001"})
    void fail(String input) {
        assertThatThrownBy(() -> new GameCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "횟수가 1 ~ 10억이면 정상 동작")
    @ValueSource(strings = {"1", "1000000000"})
    void success(String input) {
        assertThatNoException().isThrownBy(() -> new GameCount(input));
    }
}