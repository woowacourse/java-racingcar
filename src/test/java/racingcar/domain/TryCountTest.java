package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    @DisplayName("[Exception] 시도 횟수가 양의 정수가 아니면 예외를 던진다")
    void createTryCountByNotPositiveNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount(-1))
                .withMessage("시도 횟수는 양의 정수를 입력해야 합니다.");
    }

    @Test
    @DisplayName("[Exception] 시도 횟수가 1,000을 초과하면 예외를 던진다")
    void createTryCountByOver1000() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount(1001))
                .withMessage("시도 횟수는 1,000 이하여야 합니다.");
    }
}
