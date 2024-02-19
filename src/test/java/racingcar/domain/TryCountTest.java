package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.domain.TryCount.MAX_TRY_COUNT;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("[Exception] 시도 횟수가 0이나 음수이면 예외를 던진다")
    void createTryCountByNotPositiveNumber(int tryCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount(tryCount))
                .withMessage("시도 횟수는 양의 정수를 입력해야 합니다.");
    }

    @Test
    @DisplayName("[Exception] 시도 횟수가 1,000을 초과하면 예외를 던진다")
    void createTryCountByOver1000() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount(1001))
                .withMessage(String.format("시도 횟수는 %,d 이하여야 합니다.", MAX_TRY_COUNT));
    }

    @Test
    @DisplayName("[Success] 주어진 횟수만큼 전달 받은 Runnable을 실행함")
    void execute() {
        final TryCount tryCount = new TryCount(5);
        AtomicInteger tryResult = new AtomicInteger(0);

        tryCount.execute(() -> tryResult.addAndGet(1));

        assertThat(tryResult.get())
                .isEqualTo(5);
    }
}
