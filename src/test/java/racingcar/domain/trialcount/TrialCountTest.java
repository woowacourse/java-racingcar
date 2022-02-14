package racingcar.domain.trialcount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TrialCountTest {
    @ParameterizedTest
    @DisplayName("남은 시도 횟수가 0보다 큰 지 반환한다.")
    @CsvSource({"1, true", "0, false"})
    void isHigherThanZero(final int trialCountValue, final boolean expected) {
        final TrialCount trialCount = new TrialCount(trialCountValue);
        boolean actual = trialCount.isHigherThanZero();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("시도 횟수를 감소시킨다.")
    void decrease() {
        final int initialTrialCountValue = 1;
        final TrialCount trialCount = new TrialCount(initialTrialCountValue);
        trialCount.decrease();
        boolean actual = trialCount.isHigherThanZero();
        assertThat(actual).isFalse();
    }
}
