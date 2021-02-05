package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {
    @DisplayName("시도 횟수가 영어 일때")
    @Test
    public void tryCount_영어() {
        assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 음수 일때")
    @Test
    public void tryCount_음수() {
        assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
