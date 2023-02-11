package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TrialTest {
    @ParameterizedTest
    @DisplayName("숫자가 아닌 값들이 들어오면 오류가 발생하는지 확인한다")
    @ValueSource(strings = {"3ge", "~45", "2!9", "-98", "78.4"})
    void checkChar(String input) {
        assertThatThrownBy(() ->
            new Trial(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 들어왔을때 오류가 발생하는지 알아본다")
    void checkZero() {
        assertThatThrownBy(() ->
            new Trial("0")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 int 범위를 넘어가면 오류가 발생하는지 알아본다")
    void checkExtreme() {
        assertThatThrownBy(() ->
                new Trial("356574687456352313457643244567")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
