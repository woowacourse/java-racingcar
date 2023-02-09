package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-100", "1.5", "문자임"})
    @DisplayName("양의 정수가 아닐 경우 Exception 발생")
    void validateNotPositiveInteger(final String tryCount) {
        //when
        //then
        assertThatThrownBy(() -> new TryCount(tryCount));
    }

    @Test
    @DisplayName("TryCount 1에서 차감을 한번 하면 0이다.")
    void deductAndValidateZero(){
        assertThat(new TryCount("1").deduct().isZero()).isTrue();
    }
}
