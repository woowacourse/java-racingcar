package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @DisplayName("생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void create(int source) {
        assertThatCode(() -> Round.from(source))
            .doesNotThrowAnyException();
    }

    @DisplayName("라운드의 수는 최소 1 이다.")
    @Test
    void checkRoundMinRange() {
        assertThatThrownBy(() -> Round.from(0))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("라운드의 수는 최대 10 이다.")
    @Test
    void checkRoundMaxRange() {
        assertThatThrownBy(() -> Round.from(11))
            .isInstanceOf(RuntimeException.class);
    }
}
