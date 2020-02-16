package racingcargame.domain.trialtimes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.domain.trialtimes.TrialTimes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialTimesTest {

    @Test
    @DisplayName("시도 횟수는 정수로부터 생성")
    void createTrialTimes() {
        TrialTimes trialTimes = new TrialTimes(4);
        assertThat(trialTimes.getTrialTimes()).isEqualTo(4);
    }

    @Test
    @DisplayName("시도 횟수는 0이하일 경우 예외 발생")
    void createNegativeTrialTimesThrowingException() {
        assertThatThrownBy(() -> new TrialTimes(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new TrialTimes(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
