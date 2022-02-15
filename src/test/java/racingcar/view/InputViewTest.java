package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Test
    @DisplayName("입력으로 null이 들어온 경우")
    void validateInputNull() {
        assertThatThrownBy(() -> {
            InputView.validateInput(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력으로 빈 스트링이 들어온 경우")
    void validateInputEmpty() {
        assertThatThrownBy(() -> {
            InputView.validateInput("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라운드 수를 정상적으로 받은 경우")
    void validateRoundsPositiveNumber() {
        String input = "5";
        InputView.validateRounds(input);
        assertThat(5).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "가", ""})
    @DisplayName("라운드 수 입력이 숫자가 아닌 경우")
    void validateRoundsIsNotDigit(String input) {
        assertThatThrownBy(() -> {
            InputView.validateRounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("라운드 수 입력이 양수가 아닌 경우")
    void validateRoundsIsNotPositive(String input) {
        assertThatThrownBy(() -> {
            InputView.validateRounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}