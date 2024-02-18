package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptCountTest {

    @DisplayName("시도 횟수가 1보다 작다면 예외가 발생한다.")
    @Test
    void attemptCountExceptionTest() {
        assertThatThrownBy(() -> new AttemptCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1이상이라면 예외가 발생하지 않는다.")
    @Test
    void attemptCountSuccessTest() {
        assertThatCode(() -> new AttemptCount(1))
                .doesNotThrowAnyException();
    }
}
