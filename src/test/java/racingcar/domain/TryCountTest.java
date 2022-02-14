package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.exception.RacingGameIsFinishedException;

public class TryCountTest {

    @Test
    public void 정해진_횟수만큼_진행() {
        TryCount tryCount = new TryCount(2);
        assertThat(tryCount.isFinished()).isFalse();

        tryCount.increment();
        assertThat(tryCount.isFinished()).isFalse();

        tryCount.increment();
        assertThat(tryCount.isFinished()).isTrue();
    }

    @Test
    public void 정해진_횟수를_넘어서_진행시_예외_발생() {
        TryCount tryCount = new TryCount(1);
        tryCount.increment();
        assertThatThrownBy(() -> tryCount.increment())
            .isInstanceOf(RacingGameIsFinishedException.class);
    }
}
