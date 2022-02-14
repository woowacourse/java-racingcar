package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TrialCountTest {

    @Test
    void 횟수_입력_성공() {
        TrialCount trialCount = new TrialCount("3");
        assertThat(trialCount).extracting("trialCount").isEqualTo(3);
    }

    @Test
    void 횟수_문자_입력_실패() {
        assertThatThrownBy(() -> new TrialCount("ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    void 횟수_음수_입력_실패() {
        assertThatThrownBy(() -> new TrialCount("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 1 이상이어야 합니다.");
    }
}