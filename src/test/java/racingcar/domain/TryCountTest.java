package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {

    private static final int TOTAL_TRY_COUNT = 3;

    private TryCount tryCount;

    @BeforeEach
    public void setUp() {
        tryCount = new TryCount(TOTAL_TRY_COUNT);
    }

    @Test
    @DisplayName("현재_시도횟수_증가")
    public void increaseCount() {
        tryCount.increaseCount();
        assertThat(tryCount.getCurrentTryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임종료_확인")
    public void isFinished_gameOver_case() {
        tryCount.increaseCount();
        tryCount.increaseCount();
        tryCount.increaseCount();
        assertThat(tryCount.isFinished()).isTrue();
    }

    @Test
    @DisplayName("게임_진행중_확인")
    public void isFinished_gameNotOver_case() {
        tryCount.increaseCount();
        tryCount.increaseCount();
        assertThat(tryCount.isFinished()).isFalse();
    }
}
