package racingcar.model.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {
    @Test
    @DisplayName("시도 횟수 객체 생성 성공")
    public void createTryCountTest() {
        // given
        TryCount tryCount = new TryCount("1");

        // when
        // then
        assertThat(tryCount).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    @DisplayName("시도 횟수는 문자거나 음수일 수 없다")
    public void failCreateTryCount(String tryCountString) {
        assertThatThrownBy(() -> new TryCount(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }
}