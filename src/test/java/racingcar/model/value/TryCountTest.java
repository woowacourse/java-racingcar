package racingcar.model.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {
    @Test
    @DisplayName("시도 횟수 객체 생성 성공")
    public void createTryCountTest() {
        // given
        TryCount tryCount = TryCount.fromString("1");

        // when
        // then
        assertThat(tryCount).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    @DisplayName("시도 횟수는 문자거나 음수일 수 없다")
    public void failCreateTryCount(String tryCountString) {
        assertThatThrownBy(() -> TryCount.fromString(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,true", "1,false"})
    @DisplayName("tryCount 값이 같으면 equals는 true를 반환한다")
    public void equalsTest(String input, boolean expected) {
        // given
        TryCount zero = TryCount.initialize();
        TryCount comparison = TryCount.fromString(input);

        // then
        assertThat(zero.equals(comparison)).isEqualTo(expected);
    }
}