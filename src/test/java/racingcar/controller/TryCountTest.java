package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    @DisplayName("시도 횟수가 다되면 거짓이 반환되어야 한다.")
    void tryCount_countdownCompleteReturnFalse() {
        // given
        TryCount tryCount = new TryCount(5);

        // when
        while (tryCount.countdown()){
            // do something
        }

        // then
        assertThat(tryCount.countdown())
                .isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 남으면 참이 반환되어야 한다.")
    void tryCount_countdownNotCompleteReturnTrue() {
        // given
        TryCount tryCount = new TryCount(5);

        // when
        tryCount.countdown();

        // then
        assertThat(tryCount.countdown())
                .isTrue();
    }
}
