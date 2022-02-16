package racingcar.domain.round;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @DisplayName("라운드가 양수일 경우 정상적으로 생성되는지 확인")
    @Test
    void roundWithPositiveNumber() {
        Round round = new Round("3");
        assertThat(round.getRound()).isEqualTo(3);
    }

    @DisplayName("라운드가 음수, 0, 문자열일 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"-1","0","hello"})
    void roundWithNegativeNumber(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round(input))
            .withMessageContaining("1 이상의 양수");
    }
}
