package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.domain.TryCount.MAX_TRY_COUNT;

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
}
