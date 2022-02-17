package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    @DisplayName("생성 성공")
    public void success(String string) {
        // given
        TryCount tryCount = new TryCount(string);

        // when
        // then
        assertThat(tryCount).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    @DisplayName("생성 실패")
    public void failed(String tryCountString) {
        assertThatThrownBy(() -> new TryCount(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }
}