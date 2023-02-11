package racingcar.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialTimesRequestTest {
    @DisplayName("시도 횟수는 정수값만 입력 가능합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.3", "한글", "?>"})
    void validateNumberTest(String input) {
        assertThatThrownBy(() -> {
            new TrialTimesRequest(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_TRIAL_NUMBER.message());
    }

    @DisplayName("시도 횟수에 빈 값이 입력될 수 없습니다")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void validateRangeTest(String input) {
        assertThatThrownBy(() -> {
            new TrialTimesRequest(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
