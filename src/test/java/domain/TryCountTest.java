package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TryCountTest {
    @DisplayName("시도 횟수는 1회 이상이여야 합니다.")
    @Test
    public void test1() {
        Assertions.assertThatThrownBy(() -> new TryCount(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertDoesNotThrow(() -> new TryCount(50));
        assertDoesNotThrow(() -> new TryCount(1));
    }

}