package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    public static final int TOTAL_TRY_COUNT = 3;

    @Test
    public void 현재_시도횟수_증가() {
        TryCount tryCount = new TryCount(TOTAL_TRY_COUNT);
        tryCount.increaseCount();
        tryCount.increaseCount();
        assertThat(tryCount.getCurrentTryCount()).isEqualTo(2);
    }

    @Test
    public void 게임종료_확인() {
        TryCount tryCount = new TryCount(TOTAL_TRY_COUNT);
        tryCount.increaseCount();
        tryCount.increaseCount();
        tryCount.increaseCount();
        assertThat(tryCount.isFinished()).isTrue();
    }

    @Test
    public void 게임_진행중_확인() {
        TryCount tryCount = new TryCount(TOTAL_TRY_COUNT);
        tryCount.increaseCount();
        tryCount.increaseCount();
        assertThat(tryCount.isFinished()).isFalse();
    }
}
