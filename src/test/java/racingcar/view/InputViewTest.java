package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Test
    void validateInput_null() {
        assertThatThrownBy(() -> {
            InputView.validateInput(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInput_empty() {
        assertThatThrownBy(() -> {
            InputView.validateInput("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRounds_양수_숫자() {
        String input = "5";
        InputView.validateRounds(input);
        assertThat(5).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "가",""})
    void validateRounds_isNotDigit(String input) {
        assertThatThrownBy(() -> {
            InputView.validateRounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRounds_null() {
        assertThatThrownBy(() -> {
            InputView.validateRounds(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void validateRounds_isNotPositive(String input) {
        assertThatThrownBy(() -> {
            InputView.validateRounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}