package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountTest {

    @DisplayName("시도 횟수가 1보다 작다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void attemptCountExceptionTest() {
        assertThatThrownBy(() -> new AttemptCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1이상이라면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void attemptCountSuccessTest() {
        assertThatCode(() -> new AttemptCount(1))
                .doesNotThrowAnyException();
    }
}
