package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    @DisplayName("tryCount가 0일 떄 decrease시 예외가 발생한다.")
    void decrease_fail_if_tryCount_0 () {
        TryCount tryCount = new TryCount(0);

        Assertions.assertThatThrownBy(tryCount::decrease).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("게임의 시도횟수를 모두 소진했습니다.");
    }
}
