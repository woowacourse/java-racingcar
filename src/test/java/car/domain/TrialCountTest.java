package car.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrialCountTest {

    private static final int NEGATIVE_COUNT = -1;

    @Test
    void 시도_횟수는_음이_아니어야_한다() {
        assertThatThrownBy(() -> new TrialCount(NEGATIVE_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_감소할_수_있다() {
        TrialCount trialCount = new TrialCount(2)
                .decrease()
                .decrease();

        assertThat(trialCount.isLeft()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "0,false"})
    void 남은_횟수가_있는지_알_수_있다(int trialCount, boolean expected) {
        boolean isTrialCountLeft = new TrialCount(trialCount).isLeft();
        assertThat(isTrialCountLeft).isEqualTo(expected);
    }
}
