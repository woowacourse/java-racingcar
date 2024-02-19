package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 120})
    void 시도_횟수가_올바를_때_예외가_발생하지_않는다(int tryCount) {
        // when & then
        assertDoesNotThrow(() -> new TryCount(tryCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 121})
    void 시도_횟수가_올바르지_않을_때_예외가_발생한다(int tryCount) {
        // when & then
        assertThatThrownBy(() -> new TryCount(tryCount))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 " + TryCount.MIN_TRY_COUNT + " 이상 " + TryCount.MAX_TRY_COUNT + " 이하여야 합니다.");
    }

    @Test
    void 시도_횟수가_0이_아닐_때_시도횟수를_감소시키면_예외가_발생하지_않는다() {
        // given
        TryCount tryCount = new TryCount(1);

        // when & then
        assertDoesNotThrow(tryCount::decreaseTryCount);
    }

    @Test
    void 시도_횟수가_0일_때_시도횟수를_감소시키면_예외가_발생한다() {
        // given
        TryCount tryCount = new TryCount(1);
        tryCount.decreaseTryCount();

        // when & then
        assertThatThrownBy(tryCount::decreaseTryCount)
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage("시도 횟수가 모두 소진되었습니다.");
    }

    @Test
    void 시도횟수가_있는지_확인한다() {
        // given
        TryCount tryCount = new TryCount(1);

        // when & then
        assertTrue(tryCount.hasTryCount());
    }

    @Test
    void 시도횟수가_없는지_확인한다() {
        // given
        TryCount tryCount = new TryCount(1);
        tryCount.decreaseTryCount();

        // when & then
        assertFalse(tryCount.hasTryCount());
    }
}
