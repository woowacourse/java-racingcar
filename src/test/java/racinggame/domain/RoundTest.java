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
        assertThatCode(() -> new Round(source))
            .doesNotThrowAnyException();
    }

    @DisplayName("라운드의 수는 최소 1 이다.")
    @Test
    void checkRoundMinRange() {
        assertThatThrownBy(() -> new Round(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라운드의 수는 최대 10 이다.")
    @Test
    void checkRoundMaxRange() {
        assertThatThrownBy(() -> new Round(11))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
