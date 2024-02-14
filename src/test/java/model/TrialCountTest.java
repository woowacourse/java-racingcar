package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class TrialCountTest {
    @Test
    @DisplayName("숫자는 음수가 될 수 없다.")
    void validatePositive() {
        int number = -1;
        assertThatThrownBy(() -> new TrialCount(number)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("횟수가 남아있는지 알 수 있다.")
    void isRest() {
        TrialCount trialCount = new TrialCount(1);
        assertAll(
                () -> assertThat(trialCount.isRest()).isTrue(),
                () -> trialCount.reduce(),
                () -> assertThat(trialCount.isRest()).isFalse()
        );
    }

}