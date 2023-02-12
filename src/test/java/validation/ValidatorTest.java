package validation;

import domain.validator.CarValidator;
import domain.validator.GameTrialCountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123,,gray12", "echo1234"})
    @DisplayName("자동차 이름의 길이가 1~5이 아닌 경우 예외가 발생한다")
    public void validateCarNameFail(String carNames) {
        assertThatThrownBy(() -> CarValidator.validateCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_INPUT_NAME.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings  = {"0", "-1", "-5"})
    @DisplayName("게임 시도 횟수가 1보다 작은 경우 예외가 발생한다")
    public void validateGameTrialCount(String trialCount) {
        assertThatThrownBy(() -> GameTrialCountValidator.validateTrialCount(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_INPUT_NUMBER.getErrorMessage());
    }
}
