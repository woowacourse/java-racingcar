package racingcar.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialTimesTest {

    @DisplayName("시도 횟수는 정수값만 입력 가능합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.3", "한글", "?>"})
    void validateNumberTest(String input) {
        assertThatThrownBy(() -> {
            new TrialTimes(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_TRIAL_NUMBER.message());
    }

    @DisplayName("시도 횟수는 1 이상 100 이하여야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "101"})
    void validateRangeTest(String input) {
        assertThatThrownBy(() -> {
            new TrialTimes(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}