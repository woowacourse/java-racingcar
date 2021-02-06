package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.GoForwardOrStop;

public class GoForwardOrStopTest {

    @DisplayName("숫자를 입력받아 전진 여부 결정")
    @Test
    void isGoForward() {
        int goForwardNumber = 4;
        int stopNumber = 3;

        Assertions.assertThat(GoForwardOrStop.isGoForward(goForwardNumber)).isTrue();
        Assertions.assertThat(GoForwardOrStop.isGoForward(stopNumber)).isFalse();
    }
}
