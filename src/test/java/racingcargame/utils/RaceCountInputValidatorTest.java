package racingcargame.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceCountInputValidatorTest {

    @Test
    @DisplayName("입력한 경주 횟수가 숫자가 아닐 시 예외")
    void inputStringRaceCountException() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount("3a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("입력한 경주 횟수가 null인 경우")
    void inputNullException() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }

    @Test
    @DisplayName("입력한 경주 횟수가 space 하나인 경우")
    void inputBlankException() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }

    @Test
    @DisplayName("아무것도 입력하지 않았을 경우")
    void inputEmptyException() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수를 입력해주세요.");
    }

    @Test
    @DisplayName("입력한 경주 횟수가 0일 시 예외")
    void InputZeroRaceCount() {
        assertThatThrownBy(() -> {
            RaceCountInputValidator.validateRaceCount("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주횟수는 1이상의 값을 입력해주세요.");
    }
}