package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("시도 횟수 테스트")
public class AttemptsTest {

    @DisplayName("정상적인 시도 횟수인가")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void valid_attempts_number_test(int numberOfAttempts) {
        assertThatCode(() -> new Attempts(numberOfAttempts))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상적인 시도 횟수인가")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 11})
    void invalid_attempts_number_test(int numberOfAttempts) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Attempts(numberOfAttempts));
    }
}
