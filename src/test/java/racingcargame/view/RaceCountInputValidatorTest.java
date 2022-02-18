package racingcargame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceCountInputValidatorTest {

    @Test
    @DisplayName("입력한 경주 횟수가 숫자가 아닐 시 예외")
    void inputStringRaceCountException() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCountInput("3a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("입력한 경주 횟수가 null인 경우")
    void inputBlankException() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCountInput(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("경주 횟수가 공백이거나 비어있는 경우")
    @ValueSource(strings = {" ", ""})
    void inputNullException(String input) {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCountInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }
}