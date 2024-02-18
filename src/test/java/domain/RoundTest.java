package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundTest {

    @DisplayName("0 이하의 값을 입력하면 예외가 발생한다.")
    @Test
    void invalidRapCount() {
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(IllegalArgumentException.class);
    }

}
