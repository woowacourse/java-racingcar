package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    public void 정상_시도횟수(String string) {
        // given
        TryCount tryCount = new TryCount(string);

        // when
        // then
        assertThat(tryCount).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    public void 생성_예외(String tryCountString) {
        assertThatThrownBy(() -> new TryCount(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }
}