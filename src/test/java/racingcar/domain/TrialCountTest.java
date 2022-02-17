package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrialCountTest {

    @DisplayName("횟수 객체 생성")
    @Test
    void createTrialCount() {
        TrialCount trialCount = new TrialCount("3");
        assertThat(trialCount).extracting("trialCount").isEqualTo(3);
    }

    @DisplayName("횟수에 문자 입력")
    @Test
    void trialCountValidation1() {
        assertThatThrownBy(() -> new TrialCount("ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 숫자로 입력해야 합니다.");
    }

    @DisplayName("횟수에 음수 입력")
    @Test
    void trialCountValidation2() {
        assertThatThrownBy(() -> new TrialCount("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 1 이상이어야 합니다.");
    }
}