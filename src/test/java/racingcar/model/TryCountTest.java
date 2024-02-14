package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {


    @DisplayName("유효하지 않은 입력 시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1"})
    void invalidInput(String value) {
        // given
        // when
        // then

        Assertions.assertThatThrownBy(() -> TryCount.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Disabled
    @DisplayName("라운드 횟수 실행")
    @Test
    void from() {
        // given
        // when
        TryCount tryCount = TryCount.from("5");

        // then

    }
}