package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.TrialTime;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialTimeTest {

    @Test
    void 시도횟수_0이하일_경우_예외발생(){
        assertThatThrownBy(() -> {
            TrialTime trialTime = new TrialTime(-4);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 음수가 입력될 수 없습니다.");
    }
}
