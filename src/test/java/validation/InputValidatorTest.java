package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Parser;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123,,gray12", "aa, ", ""})
    @DisplayName("입력된 자동차 이름이 null 또는 공백만 있는 경우 예외가 발생한다")
    public void validateCarNameFail(String carNames) {
        assertThatThrownBy(() -> InputValidator.validateCarName(Parser.parse(carNames, ",")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings  = {"abc", "@", "!", " ", ""})
    @DisplayName("게임 시도 횟수가 숫자가 아닌 경우 예외가 발생한다")
    public void validateGameTrialCount(String trialCount) {
        assertThatThrownBy(() -> InputValidator.validateTrialCount(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_TRIAL_NUMBER.getMessage());
    }
}
