package racingcar.model.trialtimes;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.ErrorMessage;

class TrialTimesTest {
    @DisplayName("시도 횟수는 100을 넘을 수 없다.")
    @Test
    void validateMaxRangeTest() {
        int overRangeNumber = 101;
        assertThatThrownBy(() -> {
            new TrialTimes(overRangeNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRIAL_NUMBER_OVER_RANGE.message());
    }

    @DisplayName("시도 횟수는 1보다 작을 수 없다")
    @Test
    void validateMinRangeTest() {
        int overRangeNumber = 0;
        assertThatThrownBy(() -> {
            new TrialTimes(overRangeNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRIAL_NUMBER_UNDER_RANGE.message());
    }

}
