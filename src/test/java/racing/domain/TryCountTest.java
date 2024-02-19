package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @Test
    @DisplayName("정상적으로 TryCount를 생성합니다.")
    void createTryCount() {
        assertDoesNotThrow(() -> new TryCount(5));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("시도 횟수가 0 이하의 숫자인 경우 예외")
    void createTryCountWithUnderZero(int invalidCount) {
        assertThatThrownBy(() -> new TryCount(invalidCount))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("시도횟수가 남아있다면 True를 반환합니다.")
    void isRemain() {
        TryCount tryCount = new TryCount(1);

        assertTrue(tryCount.isRemain());
    }
    @Test
    @DisplayName("시도횟수가 남아있지않다면 True를 반환합니다.")
    void isRemainWithZero() {
        TryCount tryCount = new TryCount(1);

        tryCount.consume();

        assertFalse(tryCount.isRemain());
    }

    @Test
    @DisplayName("시도횟수가 차감됩니다.")
    void consume() {
        TryCount tryCount = new TryCount(1);

        tryCount.consume();

        assertFalse(tryCount.isRemain());
    }
}