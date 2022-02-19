package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialNumTest {

    @Test
    @DisplayName("TrialNum에 입력 값이 숫자가 아닌 경우 예외처리")
    void notNumberException() {
        assertThatThrownBy(() -> new TrialNum("hello"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자여야 합니다");
    }
}
