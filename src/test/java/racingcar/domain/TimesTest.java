package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TimesTest {
    @Test
    @DisplayName("정상적인 입력과 생성")
    void validTimes() {
        assertThat(new Times("10")).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "", " "})
    @DisplayName("숫자가 아닌 입력 시 예외발생")
    void characterConstructingTimes(String value) {
        assertThatThrownBy(() -> {
            new Times(value);
        }).isInstanceOf(NumberFormatException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "0"})
    @DisplayName("음수 또는 0의 경우 예외발생")
    void zeroOrBelowConstructingTimes(String value) {
        assertThatThrownBy(() -> {
            new Times(value);
        }).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("null의 경우 예외 발생")
    void nullConstructingTimes() {
        assertThatThrownBy(() -> {
            new Times(null);
        }).isInstanceOf(Exception.class);
    }
}
