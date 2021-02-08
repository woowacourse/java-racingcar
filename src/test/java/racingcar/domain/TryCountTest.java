package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TryCountTest {
    @Test
    @DisplayName("시도 횟수가 영어인 경우")
    void tryCount_영어() {
        assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 음수인 경우")
    void tryCount_음수() {
        assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
